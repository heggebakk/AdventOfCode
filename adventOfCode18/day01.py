with open('day1.txt') as f:
    src = f.read().splitlines()

total = sum(map(int, src))
print('Part 1:', total)


def new_frequency(this_src):
    temp_sum = 0
    l = {temp_sum}
    while True:
        for line in this_src:
            temp_sum += int(line)
            if temp_sum in l:
                return temp_sum
            l.add(temp_sum)


out = new_frequency(src)
print('Part 2:', out)