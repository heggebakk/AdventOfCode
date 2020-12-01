# with open('testfile.txt') as f:
with open('luke1.txt') as f:
    src = f.read().splitlines()

total = 0
high = 0
for line in src:
    line = int(line)
    if line >= high:
        high = line
        total += high
print(total)