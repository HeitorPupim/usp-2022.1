#include <cabecalho.h>

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
    }

}
/*
long search(int id, INDEX* noCabeca){
    INDEX* index =noCabeca;
    //INDEX* index= (INDEX*)malloc(sizeof(INDEX));
    index = noCabeca;
    do{
        if(index->id == id){
            long byteOffset = index->byteOffset;
            return byteOffset;
        }else{
            if(index->proxIndex ==NULL){
                printf("Registro nao encontrado!\n");
                return -1;
            }else{
                index= index->proxIndex;
            }
        }
    }while(1==1);
}  
*/