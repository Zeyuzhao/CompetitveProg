def path(park):
    dp = [[0] * len(park[0]) for _ in range(len(park))]

    dp[0][0] = park[0][0]

    for i in range(1, len(park[0])):
        dp[0][i] = dp[0][i-1] + park[0][i]

    for i in range(1, len(park)):
        dp[i][0] = dp[i-1][0] + park[i][0]

    for i in range(1, len(park)):
        for j in range(1, len(park[0])):
            dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + park[i][j]

    return dp[len(park) - 1][len(park[0]) - 1]


if __name__ == '__main__':
    with open('StressfulParkIN.txt','r') as f:
        while True:
            s = f.readline()
            if s == '':
                break
            N, M = map(int, s.strip().split())
            park = []
            for i in range(N):
                park.append(list(map(int, f.readline().strip().split())))
            print(path(park))
