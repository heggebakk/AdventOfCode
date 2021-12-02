cmake_minimum_required(VERSION 3.20)
project(adventOfCode21 C)

set(CMAKE_C_STANDARD 11)

add_executable(adventOfCode21 main.c solutions/day1.c solutions/day1.h fileParser.c fileParser.h)
