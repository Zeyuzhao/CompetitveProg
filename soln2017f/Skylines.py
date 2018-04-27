class Building:
    def __init__(self, left, height, right):
        self.left = left
        self.height = height
        self.right = right

    def __repr__(self):
        return 'Building({}, {}, {})'.format(
            self.left, self.height, self.right)

class Strip:
    def __init__(self, left, height):
        self.left = left
        self.height = height

    def __repr__(self):
        return 'Strip({}, {})'.format(self.left, self.height)

def skylines(buildings):
    """
    :buildings a list of Building

    :return a list of Strip
    """
    return skylines_helper(buildings, 0, len(buildings) - 1)

def dedup_append(strips, new_strip):
    if len(strips) > 0 and strips[-1].height == new_strip.height:
        return
    elif len(strips) > 0 and strips[-1].left == new_strip.left:
        strips[-1].height = max(strips[-1].height, new_strip.height)
        return

    strips.append(new_strip)

def merge(left_strips, right_strips):
    i, j = 0, 0
    h1, h2 = 0, 0

    ret = []

    while i < len(left_strips) and j < len(right_strips):
        left_strip = left_strips[i]
        right_strip = right_strips[j]

        if left_strip.left < right_strip.left:
            x1 = left_strip.left
            h1 = left_strip.height

            max_h = max(h1, h2)
            dedup_append(ret, Strip(x1, max_h))
            i += 1

        elif right_strip.left < left_strip.left:
            x2 = right_strip.left
            h2 = right_strip.height

            max_h = max(h1, h2)
            dedup_append(ret, Strip(x2, max_h))
            j += 1

        else:
            x1 = left_strip.left
            x2 = right_strip.left

            h1 = left_strip.height
            h2 = right_strip.height

            max_h = max(h1, h2)
            dedup_append(ret, Strip(x1, max_h))

            i += 1
            j += 1

    for i2 in range(i, len(left_strips)):
        dedup_append(ret, left_strips[i2])

    for j2 in range(j, len(right_strips)):
        dedup_append(ret, right_strips[j2])

    return ret

def skylines_helper(buildings, l, r):
    if r < l:
        return []

    if l == r:
        base_case = []
        dedup_append(base_case, Strip(buildings[l].left, buildings[l].height))
        dedup_append(base_case, Strip(buildings[l].right, 0))
        return base_case

    mid = (l + r) // 2

    left_result = skylines_helper(buildings, l, mid)
    right_result = skylines_helper(buildings, mid + 1, r)

    m = merge(left_result, right_result)
    return m

def parse_input(name):
    buildings = []
    with open(name, mode='r') as f:

        while True:
            line = f.readline()
            if line == '': # EOF
                break

            n = int(line)
            buildings = []
            for _ in range(n):
                line = f.readline()
                building_as_list = map(int, line.split(','))

                buildings.append(Building(*building_as_list))

            print(skylines(buildings))

if __name__ == '__main__':
    parse_input('SkylinesIN.txt')
