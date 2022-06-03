#include "cabecalho.h"
#include <insert.h>
#include <util.h>

FILE* abrirArquivo(){
    FILE* arquivo = fopen("bin.data","w+b");
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

    PAGE* page = (PAGE*)malloc(PAGESIZE);
    page->ehFolha = true;
    page->numberOfIndex=0;
    for(int i=0;i<NUMAXINDEX;i++){
        page->filhos[i] = -1;
    }
    for(int i=0;i<NUMAXINDEX;i++){
        page->index[i] = index;
    }
    //free(index);
    return page;
}

PAGE* abrirPage(FILE* indexFile, long byteOffset){
    PAGE* page = (PAGE*)malloc(PAGESIZE);
    fseek(indexFile,byteOffset,SEEK_SET);
    fread( &page, PAGESIZE,1,indexFile);
    return page;
}

long escreverPage(FILE* indexFile, PAGE* page){
    fseek(indexFile,0,SEEK_END);
    long byteOffset;
    byteOffset = ftell();
    fwrite(page,sizeof(PAGE),1,indexFile);
    return byteOffset;
}

INDEXOVERFLOW* criarIndexOverflow(){
    INDEXOVERFLOW* over = (INDEXOVERFLOW*)malloc(sizeof(INDEXOVERFLOW));
    over->id = -1;
    over->byteOffset=-1;
    over->filhos[0]=-1;
    over->filhos[1]=-1;
}

/*
void addIndex(INDEX* index, REGISTRO* registro, long byteOffset){
    
    if(index->id == registro->nUSP){
        printf("O Registro ja existe!\n");
    }else{
        if(index->proxIndex == NULL){
        INDEX* newIndex = (INDEX*)malloc(sizeof(INDEX));
        newIndex->id = registro->nUSP;
        newIndex->byteOffset=byteOffset;
        newIndex->proxIndex=NULL;
        index->proxIndex = newIndex;
        }
        else{
            index = index->proxIndex;
            addIndex(index, registro, byteOffset);
       }
    }
}
*/

long insert(FILE* file, INDEX* no){
    REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
    long byteOffset = ftell(file);

    fseek(file,0, SEEK_END);

    scanf("%d",&reg->nUSP);
    fwrite(&reg->nUSP,sizeof(reg->nUSP),1,file);
    
    //caractere ignorado pelo readline.
    char* ignore = readline(',');
    free(ignore);

    char* nome = readline(',');
    fwrite(nome,sizeof(reg->nome),1,file);
    free(nome);

    char* sobrenome = readline(',');
    fwrite(sobrenome,sizeof(reg->sobrenome),1,file);
    free(sobrenome);

    char* curso = readline(',');
    fwrite(curso,sizeof(reg->curso),1,file);
    free(curso);

    scanf("%e",&reg->nota);
    fwrite(&reg->nota,sizeof(reg->nota),1,file);
    
    INDEX index = criarIndex(reg->id,byteOffset);
    free(reg);
    return index;
}

void addIndexPage(INDEX* index, PAGE* page){
    
    for(int i=0;i<NUMAXINDEX;i++){
        INDEX aux;
        aux.id = index->id;
        aux.byteOffset = index->byteOffset;

        if(page->index[i].id == -1){//se page->index[i]=vazio,add o index
            page->index[i] = aux;
            break;
        }else if(page->index[i].id == index->id){// index já existe 
            printf("O Registro ja existe!\n");
            break;
        }else if(page->index[i].id > index->id){
            INDEX* aux2 = &page->index[i];
            page->index[i]=aux;
            index = aux2;
        }
    }
}

INDEXOVERFLOW* splitPage(PAGE* page, INDEX* index, FILE* indexFile){
    PAGE* newPage = criarPage();
    INDEXOVERFLOW* over = criarIndexOverflow();

    INDEX indexNulo; //se o id do index der overflow, colocaremos um index nulo.
    indexNulo.id = -1;
    indexNulo.byteOffset = -1;

    if(index->id<page->index[NUMAXINDEX].id){ // verifica se o index é o maior de todos para fazer o split page.
        INDEX aux = page->index[numberOfIndex]; 
        addIndexPage(index,page); 
        newPage->index[NUMAXINDEX/2] = aux; //adiciona o índice na nova página,caso seja o maior
    }else{ 
        newPage->index[NUMAXINDEX/2] = index; // se não for o maior, adiciona o "menor dos maiores" na nova página
    }
    over->id = page->index[NUMAXINDEX/2].id;    //adiciona o id do split ao id do split page
    for(int i=0; i<NUMAXINDEX/2; i++){
        newPage->index[i] = page->index[NUMAXINDEX/2 + 1 + i];
        page->index[NUMAXINDEX/2 + 1 + i] = indexNulo;
    }

    long byte1 = escreverPage(indexFile,Page); // registra o byte da página antiga
    over->filhos[0] = byte1;

    long byte2 = escreverPage(indexFile,newPage);  //registra o byte da nova página
    over->filhos[1] = byte2;

    return over;
}

void addIndexOverPage(INDEXOVERFLOW* over, PAGE* page){
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
            }else if(page->index[i].id == index->id){// index já existe 
                printf("O Registro ja existe!\n");
                break;
            }else if(page->index[i].id > index->id){
                INDEX* aux2 = &page->index[i];
                page->index[i]=aux;
                index = aux2;

                if(addfilho0){
                    page->filhos[i]= over->filhos[0];
                    addfilho0 = false;
                }else{
                    auxFilho = page->file[i];
                    page->file[i] = over->filhos[1];
                    over->filhos[1]= auxFilho;
                }

            }
        }
    }else{
        // se pagina estiver cheia
    }
}

void addIndex(INDEX* index, PAGE* page,FILE* indexFile){
    if(page->ehFolha == true){
        if(page->numberOfIndex < NUMAXINDEX){//se a pagina n tiver cheia
            addIndexPage(index,page);
            page->numberOfIndex++;
        }else{
            
            
            //add cógio para lidar com o overflow
        }
        
    }else{ //se a page não for flha percorre a arvore até acha a folha
        if (page->index[NUMAXINDEX].id == index->id){
                printf("O Registro ja existe!\n");
        }else if (page->index[NUMAXINDEX].id == index->id){
            PAGE pageNew = abrirPage(indexFile, page->filhos[NUMAXINDEX]);
            addIndex(index, pageNew, indexFile);
        }
        for(int i=0;i<NUMAXINDEX;i++){
            if(page->index[i].id == index->id){
                printf("index ja existe\n");
                break;
            }else if(page->index[i].id > index->id){
                PAGE pageNew = abrirPage(indexFile, page->filhos[i]);
                addIndex(index, pageNew, indexFile);
            } 

        }
    }
}