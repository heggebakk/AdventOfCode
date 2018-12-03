with open('day02.txt') as f:
    src = f.read().splitlines()

twos = 0
trees = 0
for line in src:
    two = False
    tree = False
    for i in line:
        if line.count(i) == 2 and not two:
            two = True
            twos += 1
        if line.count(i) == 3 and not tree:
            tree = True
            trees += 1
print('Part 1:', twos * trees)


def check_sum(this_src):
    for lineA in this_src:
        for lineB in this_src:
            if lineA != lineB:
                diff = 0
                for x in range(len(lineA)):
                    if lineA[x] != lineB[x]:
                        diff += 1
                if diff == 1:
                    return [lineA, lineB]


liste = check_sum(src)
a = liste[0]
b = liste[1]
out = []
for i in a:
    if i in b:
       out.append(i)
print('Part 2:', ''.join(out))
