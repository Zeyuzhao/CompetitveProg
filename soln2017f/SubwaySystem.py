def subway(vehicles, services, threshold):
    return float(vehicles) / services * 100 >= threshold

# DO NOT MODIFY BELOW THIS LINE
if __name__ == '__main__':
    with open('SubwaySystemIN.txt', 'r') as f:
        while True:
            v = f.readline()
            if v == '': # EOF
                break
            s = f.readline()
            if s == '': # EOF
                break
            t = f.readline()
            if t == '': # EOF
                break
            v = int(v)
            s = int(s)
            t = int(t)

            out = subway(v, s, t)
            if out:
                print ("true")
            else:
                print ("false")

            temp = f.readline()
