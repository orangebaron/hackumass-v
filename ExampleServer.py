import socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(("10.0.0.12", 5000))
s.listen(1000)
while True:
  try:
    client, _ = s.accept()
    img = open('img.jpg', 'wb')
    try:
      while True:
          data = client.recv(1024)
          if not data:
              break
          img.write(data)
    finally:
      img.close()
    print 'got image' #image written to img.jpg
  finally:
    client.close()
