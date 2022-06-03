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
    index.byteOffset = 0;

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

        INDEX* aux = index;

        if(page->index[i].id == -1){//se page->index[i]=vazio,add o index
            INDEX aux;
            aux.id = index->id;
            aux.byteOffset = index->byteOffset;
            page->index[i] = aux;

            break;
        }else if(page->index[i].id == index->id){// index já existe 
            printf("O Registro ja existe!\n");
            break;
        }else if(page->index[i].id > index->id){
            INDEX* aux = &page->index[i];
            page->index[i];
            index = aux;
        }
    }
}

INDEXOVERFLOW* splitPage(PAGE* page, INDEX index){
    PAGE newPage = criarPage();
    //terminar depois
}

void addIndex(INDEX* index, PAGE* page,FILE* indexFile){
    if(page->ehFolha == true){
        if(page->numberOfIndex != NUMAXINDEX){//se a pagina n tiver cheia
            addIndexPage(index,page);
            page->numberOfIndex++;
        }else{
            //add cógio para lidar com o overflow
        }
        
    }else{
        if (page->index[NUMAXINDEX]->id == index->id){
                printf("O Registro ja existe!\n");
        }else if (page->index[NUMAXINDEX]->id == index->id){
            PAGE pageNew = abrirPage(indexFile, page->filhos[NUMAXINDEX]);
            addIndex(index, pageNew, indexFile);
        }
        for(int i=0;i<NUMAXINDEX;i++){
            if(page->index[i]->id == index->id){
                printf("index ja existe\n");
                break;
            }else if(page->index[i]->id > index->id){
                PAGE pageNew = abrirPage(indexFile, page->filhos[i]);
                addIndex(index, pageNew, indexFile);
            } 

        }
    }
}