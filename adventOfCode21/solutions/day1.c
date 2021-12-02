#include <stdio.h>
#include <stdlib.h>
#include "day1.h"
#include "../fileParser.h"


void day1(char *file) {
    int fileSize = 2000;
    int *depth = malloc(sizeof(int) * fileSize);
    readDepths(file, depth);

    part1_1(depth);
    part1_2(depth);

    free(depth);
}

void part1_1(const int *depth) {
    int increased = 0;
    int current = depth[0];

    for (int i = 1; i < 2000; ++i) {
        if (current < depth[i]) {
            increased += 1;
        }
        current = depth[i];
    }
    printf("1.1:\tIncreased %d times\n", increased);
}

void part1_2(const int *depth) {
    int increased = 0;

    int current = depth[0];
    int next = depth[0] + depth[1];
    if (current < next) increased += 1;
    current = next;

    for (int i = 1; i < 2000 - 3; ++i) {
        int window = depth[i] + depth[i + 1] + depth[i + 2];
        if (current < window) increased += 1;
        current = window;
    }
    printf("1.2:\tIncreased %d times \n", increased);
}

