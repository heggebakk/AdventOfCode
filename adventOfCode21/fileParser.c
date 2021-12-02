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
