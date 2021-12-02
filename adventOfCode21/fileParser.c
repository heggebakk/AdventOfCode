#include <stdlib.h>
#include "fileParser.h"
#include "stdio.h"

void readDepths(const char *file, int *arr) {
    FILE *fileInput = fopen(file, "r");
    if (fileInput == NULL) {
        perror("Cannot open input file \n");
        exit(1);
    }
    for (int i = 0; i < 2000; ++i) {
        fscanf(fileInput, "%d", &arr[i]);
    }
    fclose(fileInput);
}

void readCommands(const char *file, int *depth, char *direction) {
    FILE *fileInput = fopen(file, "r");
    if (fileInput == NULL) {
        perror("Cannot open input file \n");
        exit(1);
    }
    for (int i = 0; i < 1000; ++i) {
        fscanf(fileInput, "%s %d", &direction[i], &depth[i]);
    }
    fclose(fileInput);
}
