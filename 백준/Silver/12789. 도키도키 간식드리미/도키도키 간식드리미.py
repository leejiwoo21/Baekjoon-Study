from sys import stdin

n = int(input())
sub_line = []
place = 1
line = map(int, stdin.readline().strip().split(' '))
line = list(line)

while True:
   if len(line) != 0 :
       if(line[0] == place):
           line.pop(0)
           place += 1
       elif len(sub_line) != 0:
           if sub_line[-1] == place:
               sub_line.pop(-1)
               place+= 1
           else:
               sub_line.append(line.pop(0))
       else:
           sub_line.append(line.pop(0))
   else:
       if len(sub_line) == 0:
           print('Nice')
           break
       elif(place == sub_line[-1]):
           place += 1
           sub_line.pop(-1)
       else:
           print('Sad')
           break