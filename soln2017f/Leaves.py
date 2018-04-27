def leaves(rolls):
    """
    :rolls is a list of dice rolls where each roll is a list of dice values.

    For example, if `rolls = [[1, 2], [3, 4, 5]]` that means that the first roll
    included two dice of values 1 and 2 and the second roll included three dice
    of values 3, 4, and 5.

    :return a Leaves Around The Tree value for each roll. In other words, return
    a list of values.
    """
    output = []

    # note the real name of this game is petals around the rose, you can find
    # the solution here: https://en.wikipedia.org/wiki/Petals_Around_the_Rose
    for roll in rolls:
        current_val = 0
        for dice in roll:
            if dice == 3:
                # there are two leaves around the tree (two dots around the
                # center dot)
                current_val += 2
            elif dice == 5:
                # there are four leaves around the tree (four dots around the
                # center dot)
                current_val += 4

        output.append(current_val)

    return output

def parse_input(name):
    rolls = []
    with open(name, mode='r') as f:
        for line in f:
            rolls.append(map(int, line.split(',')))

    output = leaves(rolls)
    print('\n'.join(map(str, output)))

if __name__ == '__main__':
    parse_input('LeavesIN.txt')
