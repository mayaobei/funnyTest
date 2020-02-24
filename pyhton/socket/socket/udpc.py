#!/usr/bin/python

import socket
import hashlib
import time

HOST = '127.0.0.1'
PORT = 9999


def udpc_rx_tx(size=64):
    tx_size = 1

    #tx_data_md5 = hashlib.md5()
    #tx_data_md5.update(tx_data)

    udpc = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    # c.settimeout(1)
    while tx_size <= size:
        tx_data = '0' * tx_size
        udpc.sendto(tx_data.encode('utf-8'), (HOST, PORT))
        rx_data, addr = udpc.recvfrom(4096)
        print("udpc | rx: %d | %s | tx: %d | %s" % (len(rx_data), set(rx_data.decode('utf-8')), len(tx_data), set(tx_data)))
        tx_size += 1
    time.sleep(2)
    udpc.close()

udpc_rx_tx(2000)
