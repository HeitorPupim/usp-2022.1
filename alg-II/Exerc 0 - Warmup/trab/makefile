all:
	gcc -Wall -Werror -g main.c trab.c -o executavel
run:
	./executavel
valgrind:
	valgrind -- tool=memecheck --leak-chech=full --track-origns=yes --show-leak-kinds=all 