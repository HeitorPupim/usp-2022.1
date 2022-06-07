#include <cabecalho.h>
#include <insert.h>

void lerRegistros(FILE* file,long byteOffset){
    if(byteOffset != -1){
        REGISTRO* reg = (REGISTRO*)malloc(sizeof(REGISTRO));
        fseek(file,byteOffset, SEEK_SET);
        printf("-------------------------------\n");

        fread(&reg->nUSP, sizeof(reg->nUSP),1, file);
        printf("nUSP: %d\n",reg->nUSP);

        char nome[25];
        fread(&nome,sizeof(nome),1,file);
        printf("Nome: %s\n",nome);

        fread(&reg->sobrenome,sizeof(reg->sobrenome),1,file);
        printf("Sobrenome: %s\n",reg->sobrenome);

        fread(&reg->curso,sizeof(reg->curso),1,file);
        printf("Curso: %s\n",reg->curso);

        fread(&reg->nota,sizeof(reg->nota),1,file);
        printf("Nota: %.2f\n",reg->nota);

        printf("-------------------------------\n");
        free(reg);
    }else{
        printf("Registro nao encontrado!\n");
    }

}

long search(int id, PAGE* pageCabeca, FILE* indexFile){
    long byteOffset;
    for(int i=0;i<NUMAXINDEX;i++){
        if(pageCabeca->index[i].id == id){
            byteOffset= pageCabeca->index[i].byteOffset; 
            return byteOffset;
            
        }else if(pageCabeca->index[i].id > id){
            if (pageCabeca->filhos[i] != -1){
                PAGE *pageNew = abrirPage(indexFile, pageCabeca->filhos[i]);
                byteOffset= search(id,pageNew, indexFile);
                return byteOffset;
            }
        } 
    }
    return byteOffset = -1;
}  
