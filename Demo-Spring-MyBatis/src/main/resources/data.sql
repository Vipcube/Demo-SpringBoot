use test;

INSERT INTO test.user (id, name, age)
VALUES (3, 'tom', 11);

INSERT INTO test.log (id, user_id, action, create_time)
VALUES (3, 3, 'read book', '2020-08-07 08:18:16');
INSERT INTO test.log (id, user_id, action, create_time)
VALUES (4, 3, 'go to the cinema', '2020-09-02 20:00:00');
INSERT INTO test.log (id, user_id, action, create_time)
VALUES (5, 3, 'have a meal', '2020-10-05 12:03:36');
INSERT INTO test.log (id, user_id, action, create_time)
VALUES (6, 3, 'have a sleep', '2020-10-06 13:00:12');
INSERT INTO test.log (id, user_id, action, create_time)
VALUES (7, 3, 'write', '2020-10-08 09:21:11');
