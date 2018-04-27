def parking(spots):
    s = sorted(spots, key=lambda x: x[0])
    result = [s[0]]
    for item in s:
        prev = result[-1]
        if item[0] <= prev[1]:
            prev[1] = max(prev[1], item[1])
        else:
            result.append(item)
    return result

# DO NOT MODIFY BELOW THIS LINE
if __name__ == '__main__':
    with open('ParkingSpotsIN.txt', 'r') as f:
        while True:
            line = f.readline()
            if line == '': # EOF
                break
            num = int(line)
            spots = []
            while num > 0:
                spots.append([int(x) for x in f.readline().split()])
                num -= 1
            print(parking(spots))
