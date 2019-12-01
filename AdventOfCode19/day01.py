with open("day01.txt", "r") as f:
    file = f.read()
    f.close()


def part_one(masses):
    total_fuel = 0

    for mass in masses.splitlines():
        total_fuel += int(mass) // 3 - 2
    return total_fuel


def part_two(masses):
    total_fuel = 0

    for mass in masses.splitlines():
        fuel = 0
        required_fuel = int(mass) // 3 - 2
        while required_fuel > 0:
            fuel += required_fuel
            required_fuel = required_fuel // 3 - 2
        total_fuel += fuel
    return total_fuel


print(f"Part1: {part_one(file)}")
print(f"Part2: {part_two(file)}")
