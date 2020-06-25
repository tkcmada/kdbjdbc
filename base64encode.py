import base64
import sys

f = open(sys.argv[1],"br")
s = base64.b64encode(f.read())
print(s.decode('ascii'))

