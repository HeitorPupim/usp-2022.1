#include <cabecalho.h>
#include <insert.h>
#include <util.h>

FILE* abrirArquivo(){
    FILE* arquivo = fopen("bin.data","w+b");
    return arquivo;
}

FILE* abrirIndexFile(){
    FILE* arquivo = fopen("index.data","w+b");
    return arquivo;
}

INDEX* criarIndex(int id, long byteOffset){
    INDEX* index = (INDEX*)malloc(sizeof(INDEX));
    index->id = id;
    index->byteOffset = byteOffset;
    return index;
}

PAGE* criarPage(){
    INDEX index;
    index.id = -1;
    index.byteOffset = -1;

    PAGE* page = (PAGE*)malloc(sizeof(PAGE));
    page->ehFolha = true;
    page->numberOfIndex=0;
    for(int i=0;i<NUMAXINDEX-1;i++){
        page->filhos[i] = -1;
        page->index[i] = index;
    }   page->filhos[NUMAXINDEX] = -1;
    return page;
}

PAGE* abrirPage(FILE* indexFile, long byteOffset){
    PAGE* page = (PAGE*)malloc(sizeof(PAGE));
    fseek(indexFile,byteOffset,SEEK_SET);
    fread( &page->ehFolha, sizeof(BOOL),1,indexFile);
    fread( &page->numberOfIndex, sizeof(short),1,indexFile);
    fread( &page->index, sizeof(page->index),1,indexFile);
    for(int i=0; i<NUMAXINDEX; i++){
        fread( &page->filhos[i], sizeof(page->filhos[0]),1,indexFile);
    }
    return page;
}

long escreverPage(FILE* indexFile, PAGE* page){
    fseek(indexFile,0,SEEK_END);
    long byteOffset;
    byteOffset = ftell(indexFile);
    fwrite(&page->ehFolha, sizeof(BOOL), 1, indexFile);
    fwrite(&page->numberOfIndex, sizeof(short), 1, indexFile);
    fwrite(page->index,sizeof(page->index),1,indexFile);
    for(int i=0; i<NUMAXINDEX; i++){
        fwrite(&page->filhos[i],sizeof(page->filhos[0]),1,indexFile);
    }
    free(page);
    return byteOffset;
}

void atualizarPage(FILE* indexFile, PAGE* page,long byteOffset){
    fseek(indexFile,byteOffset,SEEK_SET);
    fwrite(&page->ehFolha, sizeof(BOOL), 1, indexFile);
    fwrite(&page->numberOfIndex, sizeof(short), 1, indexFile);
    fwrite(page->index,sizeof(page->index),1,indexFile);
    for(int i=0; i<NUMAXINDEX; i++){
        fwrite(&page->filhos[i],sizeof(page->filhos[0]),1,indexFile);
    }
    //free(page);
}

INDEXOVERFLOW* criarIndexOverflow(){
    INDEXOVERFLOW* over = (INDEXOVERFLOW*)malloc(sizeof(INDEXOVERFLOW));
    over->id = -1;
    over->byteOffset=-1;
    over->filhos[0]=-1;
    over->filhos[1]=-1;
    return over;
}

PAGE* atualizarPageCabeca(INDEXOVERFLOW * index){
    
    PAGE* pageAUX = criarPage();
    pageAUX->index[0].id = index->id;
    pageAUX->index[0].byteOffset = index->byteOffset;
    pageAUX->filhos[0] = index->filhos[0];
    pageAUX->filhos[1] = index->filhos[1];
    pageAUX->ehFolha = false;
    pageAUX->numberOfIndex = 1;

    return pageAUX;
}

INDEX * insert(FILE* file){
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    fseek(file,0, SEEK_END);
    long byteOffset = ftell(file);

    scanf("%d",&reg->nUSP);
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    
    //caractere ignorado pelo readline.
    char* ignore1 = readline('"');
    free(ignore1);

    char* nome = readline('"');
    fwrite(nome,sizeof(reg->nome),1,file);
    free(nome);

    char* ignore2 = readline('"');
    free(ignore2);

    char* sobrenome = readline('"');
    fwrite(sobrenome,sizeof(reg->sobrenome),1,file);
    free(sobrenome);

    char* ignore3 = readline('"');
    free(ignore3);

    char* curso = readline('"');
    fwrite(curso,sizeof(reg->curso),1,file);
    free(curso);

    char* ignore4 = readline(',');
    free(ignore4);

    scanf("%e",&reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    
    INDEX *index = criarIndex(reg->nUSP,byteOffset);
    free(reg);
    return index;
}

void addIndexPage(INDEX* index, PAGE* page){

    INDEX aux;

    for(int i=0;i<NUMAXINDEX;i++){

        if(page->index[i].id == -1){//se page->index[i]=vazio,add o index
            page->index[i].id = index->id;
            page->index[i].byteOffset = index->byteOffset;
            break;
        }else if(page->index[i].id == index->id){// index já existe 
            printf("O Registro ja existe!\n");
            break;
        }else if(page->index[i].id > index->id){

            aux.id = page->index[i].id;
            aux.byteOffset = page->index[i].byteOffset;

            page->index[i].id = index->id;
            page->index[i].byteOffset = index->byteOffset;
            
            index->id = aux.id;
            index->byteOffset = aux.byteOffset;
        }
    }
    
}

INDEXOVERFLOW* splitPage(PAGE* page, INDEX* index, FILE* indexFile){

    PAGE* newPage = criarPage();
    INDEXOVERFLOW* over = criarIndexOverflow();

    INDEX indexNulo; //se o id do index der overflow, colocaremos um index nulo.
    indexNulo.id = -1;
    indexNulo.byteOffset = -1;

    INDEX aux;
    if(index->id < page->index[NUMAXINDEX].id){ // verifica se o index é o maior de todos para fazer o split page.
        
        aux.id = page->index[NUMAXINDEX].id;
        aux.byteOffset= page->index[NUMAXINDEX].byteOffset;
        addIndexPage(index,page); 
        newPage->index[NUMAXINDEX/2] = aux; //adiciona o índice na nova página,caso seja o maior

    }else{ 

        aux.id = index->id;
        aux.byteOffset = index->byteOffset;
        newPage->index[NUMAXINDEX/2] = aux; // se não for o maior, adiciona o "menor dos maiores" na nova página

    }

    over->id = page->index[NUMAXINDEX/2].id;    //adiciona o id do split ao id do split page


    for(int i=0; i<NUMAXINDEX/2; i++){
        newPage->index[i] = page->index[NUMAXINDEX/2 + 1 + i];
        page->index[NUMAXINDEX/2 + 1 + i] = indexNulo;
    }

    page->numberOfIndex = NUMAXINDEX/2;
    newPage->numberOfIndex = NUMAXINDEX/2;

    long byte1 = escreverPage(indexFile,page); // registra o byte da página antiga
    over->filhos[0] = byte1;

    long byte2 = escreverPage(indexFile,newPage);  //registra o byte da nova página
    over->filhos[1] = byte2;

    return over;
}

INDEXOVERFLOW* addIndexOverPage(INDEXOVERFLOW* over, PAGE* page, FILE* indexFile){
    
    INDEXOVERFLOW* newOverflow=NULL;
    if(page->numberOfIndex < NUMAXINDEX){ // se tiver espaço na página, adiciona o index.
        INDEX aux;
        aux.id = over->id;
        aux.byteOffset = over->byteOffset;
        long  auxFilho;
        BOOL addfilho0 =true;

        for(int i=0;i<NUMAXINDEX;i++){

            if(page->index[i].id == -1){//se page->index[i]=vazio,add o index
                page->index[i].id = over->id;
                page->index[i].byteOffset = over->byteOffset;
                page->filhos[i]=over->filhos[0];
                page->filhos[i+1]=over->filhos[1];
                break;
            }else if(page->index[i].id == over->id){// index já existe 
                printf("O Registro ja existe!\n");
                break;

            }else if(page->index[i].id > over->id){
                INDEX* aux2 = &page->index[i];
                page->index[i]=aux;
                over->id = aux2->id;
                over->byteOffset= aux2->byteOffset;

                if(addfilho0){
                    page->filhos[i]= over->filhos[0];
                    addfilho0 = false;
                }else{
                    // *** não existe "file" em page
                    auxFilho = page->filhos[i];
                    page->filhos[i] = over->filhos[1];
                    over->filhos[1]= auxFilho;
                }
            }
        }
        free(over);
        return newOverflow;
    }else{
        INDEX* index =criarIndex(over->id, over->byteOffset);
        newOverflow = splitPage(page, index,indexFile);
        free(over);
        return newOverflow;
    }
}

INDEXOVERFLOW* addIndex(INDEX* index, PAGE* page,FILE* indexFile){

    INDEXOVERFLOW* overflow = NULL;
    if(page->ehFolha == true){


        if(page->numberOfIndex < NUMAXINDEX){//se a pagina n tiver cheia
            addIndexPage(index,page);
            page->numberOfIndex++;
        }else{
            overflow = splitPage(page, index, indexFile);
        }
        return overflow;


    }else{ //se a page não for folha percorre a arvore até acha a folha

        if (page->index[NUMAXINDEX].id == index->id){
            printf("O Registro ja existe!\n");
            return overflow ;//return null

        }
        for(int i=0;i<NUMAXINDEX;i++){

            if(page->index[i].id == index->id){
                printf("index ja existe\n");
                return overflow ;//return null
            }
 
            if(page->index[i].id > index->id || page->index[i].id == -1){
            
                PAGE *pageNew = abrirPage(indexFile, page->filhos[i]);
                overflow =  addIndex(index, pageNew, indexFile);
                if(overflow == NULL) {
                    atualizarPage(indexFile, pageNew, page->filhos[i]);
                    free(pageNew);
                    return overflow;
                }
                INDEXOVERFLOW* aux=addIndexOverPage( overflow, page, indexFile);
                return aux;
            } 
        }
    }
    return overflow;
}