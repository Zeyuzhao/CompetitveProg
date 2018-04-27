def reverse(sign):
    return (sign[::-1])


if __name__ == '__main__':
    with open('PrankPlanningIN.txt', 'r') as f:
        n = f.readline().strip()
        while n != "":
            x = int(n)
            for i in range(x):
                print(reverse(f.readline().strip()))
            n = f.readline().strip()
