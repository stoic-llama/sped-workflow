
/* UserDTO Insertion */
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (1, 'Jane.Doe@my.ccsu.edu', 'Jane', 'Doe', 80802580, 'reader', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (2, 'Johnny.Cash@my.ccsu.edu', 'Johnny', 'Cash', 80802581, 'reader', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (3, 'Owen.Wilson@my.ccsu.edu', 'Owen', 'Wilson', 80802582, 'instructor', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (4, 'Will.Smith@my.ccsu.edu', 'Will', 'Smith', 80802583, 'reader', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (5, 'Raine.Dawson@my.ccsu.edu', 'Raine', 'Dawson', 80802584, 'reader', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (6, 'Jon.Snow@my.ccsu.edu', 'Jon', 'Snow', 80802585, 'reader', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (7, 'Roger.Williams@my.ccsu.edu', 'Roger', 'Williams', 80802586, 'student', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (8, 'Jim.Carrey@my.ccsu.edu', 'Jim', 'Carrey', 80802571, 'student', 'ACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (9, 'Mickey.Mouse@my.ccsu.edu', 'Mickey', 'Mouse', 80802572, 'student', 'INACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (10, 'Minnie.Mouse@my.ccsu.edu', 'Minnie', 'Mouse', 80802573, 'student', 'INACTIVE');
INSERT INTO UserDTO (uid,email,fname,lname,ccsuID,role,status) VALUES (11, 'christopher.smith@my.ccsu.edu', 'Christopher', 'Smith', 30302580, 'coordinator', 'ACTIVE');

/* User Insertion */
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (1,true,null,'$2a$12$vX6N4QHIFPl0kRGQznweZ.Mv7NbRejPh1rACg7zA604S18uTYBbRq','Jane.Doe@my.ccsu.edu',1);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (2,true,null,'$2a$12$1/1dg5W7ntY5K2wXVgwhmOC6DiVTjzAqFKpeZeMhWg8yaC7VJtenW','Johnny.Cash@my.ccsu.edu',2);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (3,true,null,'$2a$12$rXUDDdwPimbMRp6kpXOudeggxU57ierZL9w36EFz.E/t/YRhB00VC','Owen.Wilson@my.ccsu.edu',3);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (4,true,null,'$2a$12$HU.QyThgeAhcw08N2PvTCeG4XPWWvb3BLVTniItZpKndcrcB48a5K','Will.Smith@my.ccsu.edu',4);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (5,true,null,'$2a$12$sSd4Zbp9lyfBaaQOl0LpI.15Dyqr91uFy1mbJ2mcVbm37qyldTHdi','Raine.Dawson@my.ccsu.edu',5);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (6,true,null,'$2a$12$dZgmsdMn.1c5YTprTcqwxOnU85Y7aLWrE2SeolJg6VoeEFCqdysdS','Jon.Snow@my.ccsu.edu',6);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (7,true,null,'$2a$12$WdN55bpc5ElWwZ67LKlg6Od/IlkULVRnrdlXK92uL6DViHqaannU6','Roger.Williams@my.ccsu.edu',7);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (8,true,null,'$2a$12$LkB0gz.TiCWj58r/g06BtOzvmExIYoCzamo.qHnmHVeUcXvsaHiKq','Jim.Carrey@my.ccsu.edu',8);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (9,true,null,'$2a$12$mlYkem86Vyxx8pC4zEo5Pu8Nso17qAUwVXGNi/pjU0DrF96q2bkbW','Mickey.Mouse@my.ccsu.edu',9);
INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (10,true,null,'$2a$12$.RfCRZOy0mFKU7.m9xF2BOelljLoFvTmXS06TrTha0R2wgdd7aBt2','Minnie.Mouse@my.ccsu.edu',10);

INSERT INTO Users (ldid,enabled,last_login,password,username,user_uid) VALUES (11,true,null,'$2a$12$cHWHrchdpEd3K2IiHSG8.uWg8W5bPr5wX5gtTtOUz.saVuh4wYcpm','christopher.smith@my.ccsu.edu',11);

/* Authorities Insertion */
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (1,'reader','Jane.Doe@my.ccsu.edu',1);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (2,'reader','Johnny.Cash@my.ccsu.edu',2);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (3,'instructor','Owen.Wilson@my.ccsu.edu',3);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (4,'reader','Will.Smith@my.ccsu.edu',4);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (5,'reader','Raine.Dawson@my.ccsu.edu',5);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (6,'reader','Jon.Snow@my.ccsu.edu',6);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (7,'student','Roger.Williams@my.ccsu.edu',7);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (8,'student','Jim.Carrey@my.ccsu.edu',8);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (9,'student','Mickey.Mouse@my.ccsu.edu',9);
INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (10,'student','Minnie.Mouse@my.ccsu.edu',10);

INSERT INTO Authorities (uaid,authority,username,login_ldid) VALUES (11,'coordinator','christopher.smith@my.ccsu.edu',11);





/* Other Table Insertions */

INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (1, 'The purpose statement is paragraph 1, sentence 1.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (2, 'Two thirds of page 1 is summary of methodology.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (3, 'Paragraph 2 is an overview of order of results that follow.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (4, 'Subsequent paragraphs follow overview order and results are presented in a logical manner.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (5, 'Appropriate summary data are presented.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (6, 'Math calculations are computed correctly.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (7, 'Narrative introduces table/figure data.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (8, 'Narrative augments table/figure data and is not redundant to table/figure data.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (9, 'Table titles are in APA format.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (10, 'Figure captions are in APA format.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (11, 'Figure axes labeled are in APA format.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (12, 'Tables/figures are clearly readable.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (13, 'Statistical analysis is performed with correct procedures.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (14, 'Limitations are correctly defined.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (15, 'Limitations are correctly identified and explained given study implementation.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (16, 'Limitations address design flaws where appropriate.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (17, 'Relationship of action research project to literature reviewed is made by comparing results/data of action research project to results/data and/or topics/ideas of reviewed literature.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (18, 'Relationship of findings to original purpose statement is clear.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (19, 'Recommendations for practice only come from data presented in Results section.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (20, 'Recommendations for practice has minimum 3 recommendations', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (21, 'Recommendations for practice and recommendations for future research are two distinct sub-sections each with their own topic sentences.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (22, 'At least 1 recommendation for future research is based on the results/data of the action research project.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (23, 'Section headings are bold and centered.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (24, 'Use of the word “data” considered plural.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (25, 'Reference list has hanging indent format.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (26, 'Reference list has correct capitalization of journal articles, book titles, and journal names (less than 3 errors)', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (27, 'Reference list has correct use of italics for journal articles, book titles, and journal names (less than 3 errors)', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (28, 'Reference list has correct use of spacing between elements of entries (author initials, volume/number) (less than 3 errors)', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (29, 'Reference list has correct use of commas between elements of entries (less than 3 errors)', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (30, 'Numbers use APA format (less than 3 errors)', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (31, 'Entire project is double spaced.', 1, TRUE);
INSERT INTO QuestionsTemplate (qtid,display,templateId,templateActive) VALUES (32, 'Electronic file presented contains the following: Abstract; Introduction with Problem statement, Significance statement, Literature Review, and Purpose statement;
Methodology with Participants, Materials, Procedures;
Results; Limitation; Discussion; Appendices; Raw Data
', 1, TRUE);