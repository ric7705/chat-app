db = db.getSiblingDB('demo');

db.createUser(
    {
        user: "admin",
        pwd: "password",
        roles:[
            {
                role: "readWrite",
                db:   "demo"
            }
        ]
    }
);

db.createCollection("message",
    {
        capped : true,
        autoIndexId : true,
        size : 6142800,
        max : 10000
    }
);

db.createCollection("user_info");
db.createCollection("contact");


db.message.insert( [
    { from: "Jack", to: "John", content: "message 1" },
    { from: "John", to: "Jack", content: "message 2" },
    { from: "Jack", to: "John", content: "message 3" },
    { from: "John", to: "Jack", content: "message 4" },
    ]
);


db.user_info.insert(
    [
        {
            username: "Jack", pic: "https://fakeimg.pl/449x449/"
        },
        {
            username: "John", pic: "https://fakeimg.pl/449x449/"
        },
        {
            username: "Lily", pic: "https://fakeimg.pl/449x449/"
        },
        {
            username: "Sia", pic: "https://fakeimg.pl/449x449/"
        },
    ]
);

db.contact.insert(
    [
        {
            username: "Jack",
            contact: ["John", "Lily", "Sia"]
        },
        {
            username: "John",
            contact: ["Jack", "Lily", "Sia"]
        }
    ]
);