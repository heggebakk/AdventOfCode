def intcode(file):
    i = 0
    while True:
        opcode = file[i]

        if opcode == 99:
            return file[0]

        a = file[i + 1]
        b = file[i + 2]
        c = file[i + 3]

        if opcode == 1:
            file[c] = file[a] + file[b]
        if opcode == 2:
            file[c] = file[a] * file[b]
        i += 4


def replace(file, i, j):
    file[1] = i
    file[2] = j
    return intcode(file)


assert intcode([1, 0, 0, 0, 99]) == 2, intcode([1, 0, 0, 0, 99])
assert intcode([1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50]) == 3500, intcode(
    [1, 9, 10, 3, 2, 3, 11, 0, 99, 30, 40, 50]
)

with open("day02.txt", "r") as f:
    file = [int(x) for x in f.read().split(",")]

print(f"Part one: {replace(file.copy(), 12, 2)}")

for i in range(0, 100):
    for j in range(0, 100):
        out = replace(file.copy(), i, j)
        if out == 19690720:
            print(f"Part two: {100 * i + j}")
            break
