def has_pattern(st, pat):
    """
    :st an arbitrary string
    :pat a pattern like ABCABC

    :return whether the string conforms to the pattern
    """
    pat_to_sub = {}
    return has_pattern_helper(st, pat, pat_to_sub)

def has_pattern_helper(st, pat, pat_to_sub):
    if len(pat) == 0:
        return True
    elif len(pat) == 1:
        return pat not in pat_to_sub or pat_to_sub[pat] == st
    else:
        for i in range(1, len(st)):
            guess_sub = st[0:i]
            guess_pat = pat[0]

            if guess_pat in pat_to_sub and pat_to_sub[guess_pat] != guess_sub:
                continue

            pat_to_sub[guess_pat] = guess_sub

            is_valid = has_pattern_helper(st[i:], pat[1:], pat_to_sub)
            if is_valid:
                return True
            elif guess_pat in pat_to_sub:
                del pat_to_sub[guess_pat]

        return False

def parse_input(name):
    pattern_words = []
    with open(name, mode='r') as f:
        for line in f:
            pattern_words.append(line.strip().split(','))

    for p_w in pattern_words:
        print(has_pattern(p_w[1], p_w[0]))

if __name__ == '__main__':
    parse_input('PatternIN.txt')
