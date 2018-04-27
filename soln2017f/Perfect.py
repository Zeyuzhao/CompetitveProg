import math

def is_perfect(n):
    if n <= 0:
        return False

    sum = 0

    for i in range(1, int(math.ceil(math.sqrt(n)))):
        if n % i == 0:
            sum += i
            if i * i != n:
                sum += n / i

    return (sum - n) == n

if __name__ == '__main__':
    with open('PerfectIN.txt', 'r') as f:
        while True:
            n = f.readline()
            if n == '':
                break
            n = int(n)
            out = is_perfect(n)
            if out:
                print('true')
            else:
                print('false')
