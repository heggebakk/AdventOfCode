#include <malloc.h>
#include "day2.h"
#include "../fileParser.h"

void day2(char *file) {
    int *depths = malloc(sizeof(int) * 1000);
    char *directions = malloc(sizeof(char) * 1000);

    readCommands(file, depths, directions);

    part2_1(depths, directions);

    int aim = 0;
    int pos = 0;
    int depth = 0;
    for (int i = 0; i < 1000; ++i) {
        if (directions[i] == 'd') aim += depths[i];
        else if (directions[i] == 'u') aim -= depths[i];
        else if (directions[i] == 'f') {
            pos += depths[i];
            depth += aim * depths[i];
        }
    }
    printf("2.2:\tPosition: %d\n", pos * depth);

    free(depths);
    free(directions);
}

void part2_1(const int *depths, const char *directions) {
    int pos = 0;
    int depth = 0;
    for (int i = 0; i < 1000; ++i) {
        if (directions[i] == 'f') pos += depths[i];
        else if (directions[i] == 'd') depth += depths[i];
        else if (directions[i] == 'u') depth -= depths[i];
    }
    printf("2.1:\tPosition: %d\n", pos * depth);
}
