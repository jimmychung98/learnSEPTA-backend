#!/usr/bin/python3

import requests
import json
import time

SEPTA_API_BASE_URL = "http://www3.septa.org/hackathon/TransitView/trips.php?route="




def send_request(bus_num):
	septa_apiurl = SEPTA_API_BASE_URL + bus_num
	septa_response = requests.get(septa_apiurl)
	septa_json = septa_response.json();
	return septa_json


def dump_json(filename, data):
	with open(filename, 'w') as outfile:
		json.dump(data, outfile)

def main():
	no = 0
	busnum = '17'
	nexttime = time.time()
	while True:
		json_data = send_request(busnum)
		filename = 'data/'+'bus'+busnum+'_data_'+str(no)+'.json'
		dump_json(filename, json_data)
		print('{} has been created'.format(filename))
		no += 1
		# Sleep for 10 seconds
		nexttime += 10
		sleeptime = nexttime - time.time()
		if sleeptime > 0:
			time.sleep(sleeptime)


if __name__=='__main__':
	main()