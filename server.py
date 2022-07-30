import socket
# Socket Class Import


sock = socket.socket()
print("[Server]: Socket successfully created.")
# Empty socket object

port = 8000
# Port
try:
    sock.bind(('127.0.0.1',port))
except socket.error as err:
    print("[Server]: Binding failed with error code " .format(err))

# bind to the port

sock.listen(5)
print("[Server]: Socket is listening..")

# listen

while True:
    c,addr = sock.accept() #Establish a connection with the client
    print ("Got connection from", addr)
    c.send(bytes("From Server: Thank you for connecting!\n", 'UTF-8'))
    data = c.recv(1024)
    print(data.decode(encoding='UTF-8'))
    c.close()