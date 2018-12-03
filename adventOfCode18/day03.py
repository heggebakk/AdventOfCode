with open('day03.txt') as f:
    src = f.read().splitlines()

marked = set()
two_claims = set()
count = 0
id_to_use = 0


def counter(x, y, width, height, marked_list, twoclaims):
    total = 0

    for i in range(int(width)):
        for j in range(int(height)):
            if (x + i, y + j) in marked_list:
                if (x + i, y + j) not in twoclaims:
                    total += 1
                    two_claims.add((x + i, y + j))
            else:
                marked_list.add((x + i, y + j))
    return total


for line in src:
    words = line.split(' ')
    edges = words[2].split(',')
    dimension = words[3].split('x')

    id_claim = words[0].replace('#', '')
    left_edge_claim = int(edges[0])
    top_edge_claim = int(edges[1].replace(':', ''))
    width_claim = int(dimension[0])
    height_claim = int(dimension[1])

    count += counter(left_edge_claim, top_edge_claim, width_claim, height_claim, marked, two_claims)


def check_id(x, y, width, height, twoclaims):
    check = True

    for i in range(int(width)):
        for j in range(int(height)):
            if (x + i, y + j) in twoclaims:
                check = False
    return check


for line in src:
    words = line.split(' ')
    edges = words[2].split(',')
    dimension = words[3].split('x')

    id_claim = words[0].replace('#', '')
    left_edge_claim = int(edges[0])
    top_edge_claim = int(edges[1].replace(':', ''))
    width_claim = int(dimension[0])
    height_claim = int(dimension[1])

    if check_id(left_edge_claim, top_edge_claim, width_claim, height_claim, two_claims):
        id_to_use = id_claim

print('Part 1:', count)
print('Part 2:', id_to_use)
