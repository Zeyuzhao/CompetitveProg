def bridge(l):
    d = {}
    count = 0
    start, end = 0, 0
    for i, el in enumerate(l):
        count += (1 if el == 'P' else -1)
        if count != 0 and count in d.keys() and end - start < i - d[count]:
            start = d[count] + 1
            end = i
        elif count == 0:
            start = 0
            end = i
        else:
            d[count] = i
    return end - start + 1

if __name__ == '__main__':
    with open('RubyBridgeIN.txt', 'r') as f:
        while True:
            s = f.readline().strip()
            if s == '':
                break
            N = int(s)
            s = f.readline().strip()
            print(str(bridge(s)))