import tornado.ioloop
import tornado.web
import os.path
import json
import bson.json_util
from pymongo import MongoClient

class MainHandler(tornado.web.RequestHandler):
    def get(self):
        self.write("This is HL")

class ApiHandler(tornado.web.RequestHandler):
    def get(self, elem):
        values = []
        client = MongoClient('mongodb://jorgeboneu:4343870@kahana.mongohq.com:10084/HLDB')
        db = client['HLDB']
        collection = db[elem]
        
        for item in collection.find():
            values.append(item)
        self.write(json.dumps(values, default=bson.json_util.default))

    def post(self, elem):
        client = MongoClient('mongodb://jorgeboneu:4343870@kahana.mongohq.com:10084/HLDB')
        db = client['HLDB']
        print(self.request.body)
        input = json.loads(self.request.body)
        collection = db[elem]
        post_id = collection.insert(input)
        self.write('{"ok":1}')
        #self.write(self.request.body)
		

static_path=os.path.join(os.path.dirname(__file__), "front")
application = tornado.web.Application(
    [
        (r"/", MainHandler),
        (r"/api/(.*)", ApiHandler),
        (r'/(.*)', tornado.web.StaticFileHandler, {'path': static_path}),
    ],
    )

if __name__ == "__main__":
    application.listen(9999)
    tornado.ioloop.IOLoop.instance().start()
