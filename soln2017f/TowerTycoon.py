from collections import defaultdict


def tower(l):
    people = list(set().union(*l))
    people_to_ids = {p: i for i, p in enumerate(people)}
    outs = defaultdict(lambda: [0, []], {})
    order, queue = [], []
    for seq in l:
        for i in range(len(seq) - 1):
            if people_to_ids[seq[i+1]] not in outs[seq[i]][1]:
                outs[seq[i]][1].append(people_to_ids[seq[i+1]])
            outs[seq[i+1]][0] += 1

    for i, person in enumerate(people):
        if outs[person][0] == 0:
            queue.append(i)

    while len(queue) != 0:
        a = queue.pop(0)
        order.append(people[a])
        for next_person_id in outs[people[a]][1]:
            outs[people[next_person_id]][0] -= 1
            if outs[people[next_person_id]][0] == 0:
                queue.append(next_person_id)
    return order


if __name__ == '__main__':
    with open('TowerTycoonIN.txt','r') as f:
        while True:
            s = f.readline()
            if s == '':
                break
            s = int(s)
            l = []
            for i in range(s):
                l.append(f.readline().strip().split())
            print('[' + ', '.join(tower(l)) + ']')