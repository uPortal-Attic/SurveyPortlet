--
-- Licensed to Apereo under one or more contributor license
-- agreements. See the NOTICE file distributed with this work
-- for additional information regarding copyright ownership.
-- Apereo licenses this file to you under the Apache License,
-- Version 2.0 (the "License"); you may not use this file
-- except in compliance with the License.  You may obtain a
-- copy of the License at the following location:
--
--   http://www.apache.org/licenses/LICENSE-2.0
--
-- Unless required by applicable law or agreed to in writing,
-- software distributed under the License is distributed on an
-- "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
-- KIND, either express or implied.  See the License for the
-- specific language governing permissions and limitations
-- under the License.
--

insert into survey_survey (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99991, 'Test Survey 1 description', 's1_text', now(), 'admin', 0, 'Test Survey 1', 'sur1');
insert into survey_survey (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99992, 'Test Survey 2 description', 's2_text', now(), 'admin', 0, 'Test Survey 2', 'sur2');
insert into survey_survey (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99993, 'CCC Lifestyle Survey', 'lifestyle_text', now(), 'admin', 0, 'Lifestyle Survey', 'lifestyle');
insert into survey_survey (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name)

values (99994, 'Your Wellbeing - Student Assessment', 'uom_wellbeing_text', now(), 'admin', 0, 'Your Wellbeing', 'wellbeing');
insert into survey_survey (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name)
values (99995, 'Your Learning Student Assessment', 'uom_learning_text', now(), 'admin', 0, 'Your Learning', 'learning');

insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999101, 'Course types desired', 0, 'Indicate the types of courses you desire to take', 'courseType');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999102, 'Employment Status', 0, 'Please indicate the number of hours you are currently employed','employmentStatus');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999103, 'Childcare needed', 0, 'Please indicate the type of childcare needed to attend college', 'childcare');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999104, 'Willing Commute Distance', 0, 'How far would you commute in order to attend college?', 'commuteDistance');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999105, 'Commute Transportation', 0, 'Will you be using public transportation to attend college?', 'commutePublicTransport');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999106, 'Relocate in order to attend?', 0, 'Are you willing to relocate to attend college?', 'commuteRelocate');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999107, 'Change college based on interests?', 0, 'Are you willing to change your college choice based on your needs and interests?', 'changeBasedOnInterests');
insert into survey_question (id, alt_text, status, text, canonical_name) 
values (9999108, 'Select all that apply', 0, 'Please select all of the following that apply to you:', 'studentAtrributes');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999201, 'Someone to talk to', 0, 'There is usually someone I can talk to about my day-to-day problems', 'someoneTalkTo');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999202, 'My circle limited', 0, 'I find my circle of friends and acquaintances too limited', 'limitedCircle');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999203, 'Enough close people', 0, 'There are enough people I feel close to', 'closePeople');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999204, 'People care about me', 0, 'There are people in my life who really care about me', 'caringPeople');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999205, 'I get out', 0, 'I get out and about enough', 'getOut');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999206, 'I enjoy being active', 0, 'I enjoy physical activities like walking, gardening, dancing', 'enjoyGettingPhysical');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999207, 'I find time to be active', 0, 'I find the time to be physically active most weeks', 'findTimeToBeActive');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999208, 'I do different activities', 0, 'I get involved in different sports and physical activities', 'differentActivities');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999209, 'I know my thoughts', 0, 'I am aware of what thoughts are passing through my mind', 'myThoughts');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999210, 'I can express my feelings', 0, 'I''m good at finding words to describe my feelings', 'expressFeelings');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999211, 'I have challenges focusing', 0, 'When I do things, my mind wanders off and I''m easily distracted', 'mindWanders');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999212, 'I find it hard to describe what I am thinking', 0, 'It''s hard for me to find the words to describe what I''m thinking', 'findWords');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999213, 'I get things done', 0, 'Most days I feel a sense of accomplishment from what I do', 'senseOfAccomplishment');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999214, 'I find things that interest me', 0, 'I think the world’s too interesting to feel bored very often', 'worldIsInteresting');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999215, 'I enjoy learning', 0, 'I love learning new things', 'loveLearning');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999216, 'I do worthwhile things', 0, 'I generally feel that what I do in my life is valuable and worthwhile', 'feelValuable');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999217, 'I help others', 0, 'I feel that I have helped someone in big or small ways', 'helpSomeone');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999218, 'I volunteer', 0, 'I volunteer my time to help others', 'volunteer');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999219, 'I matter to others', 0, 'I feel that I make a difference to other people’s lives', 'makeDifference');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999220, 'I help others be positive', 0, 'I actively contribute to the happiness and wellbeing of others', 'positiveVibes');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999221, 'I am self-sufficient', 0, 'I feel able to take care of myself', 'takeCareSelf');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999222, 'I take care of myself physically', 0, 'I make sure I treat my body well', 'takeCareOfBody');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999223, 'I keep balance between my needs and interests', 0, 'I have a good balance in my life', 'lifeBalance');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999224, 'I do not take dangerous risks', 0, 'I don’t take risks with my physical or mental health', 'noRisks');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999301, 'I am a team player', 0, 'I know how to work well in groups', 'teamPlayer');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999302, 'I am adaptable to learning', 0, 'I feel comfortable exploring new ways of learning topics ', 'adaptableAtLearning');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999303, 'I know how best I learn', 0, 'I understand what I need to do to learn most effectively ', 'effectiveLearner');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999304, 'I experiment when I am stuck', 0, 'I often try something new when I feel stuck', 'experimentWhenStuck');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999305, 'I have good time management skills', 0, 'I know how to manage my time', 'manageTime');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999306, 'I know how to prioritise', 0, 'I feel comfortable prioritising and working with multiple deadlines', 'prioritising');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999307, 'I know that planning can lead to success', 0, 'I understand the impact that planning can have on my success', 'planSuccess');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999308, 'I plan ahead', 0, 'I often plan ahead to make sure I complete all tasks', 'planAhead');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999309, 'I can search various sources for information', 0, 'I feel comfortable searching for information from a variety of sources', 'searchVariety');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999310, 'I know how to evaluate quality of information', 0, 'I understand what is required to analyse the validity and quality of information', 'analyseQuality');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999311, 'I know how categorize information', 0, 'I know how to group information from a range of sources to prepare for analysis', 'groupInformation');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999312, 'I consider the source of information', 0, 'I often think about where information has originated', 'origination');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999313, 'I can form opinions based on other''s work', 0, 'I feel comfortable forming opinions on the work of others', 'opinionsBasedOnOthers');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999314, 'I can incorporate my work', 0, 'I understand how incorporate my opinion into analysis of the work of others', 'incorporateMyWork');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999315, 'I can summarize what I have read', 0, 'I know how to summarise and rephrase what I have read ', 'rephrase');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999316, 'I share my understanding', 0, 'I often apply my own understanding to others’ ideas', 'understanding');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999317, 'I know how to write an academic essay', 0, 'I know what is required in an academic essay', 'academicEssay');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999318, 'I can include my ideas within academic work', 0, 'I feel comfortable including my own ideas within academic work', 'includeInAcademicWork');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999319, 'I can present my ideas for maximum impact', 0, 'I understand how to structure my ideas for maximum impact', 'maxImpact');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999320, 'I welcome feedback', 0, 'I often ask use feedback on one assignment to improve the next', 'welcomeFeedback');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999321, 'I know how to revise', 0, 'I know what I need to revise effectively', 'revise');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999322, 'I can revise multiple topics/courses concurrently', 0, 'I feel comfortable revising for multiple topics/courses at once', 'revisingConcurrently');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999323, 'I can select revising methods appropriately', 0, 'I understand how to select the best method for revising for a particular course', 'revisingMethod');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999324, 'I often include time for revision in my work', 0, 'I often build revision into my regular term-time work', 'revisionIncluded');

insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (2, 1, 9999101, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 2, 9999102, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 3, 9999103, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 4, 9999104, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999105, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999106, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999107, 99993);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999108, 99993);

insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 1, 9999201, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 2, 9999202, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 3, 9999203, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 4, 9999204, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999205, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999206, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 7, 9999207, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 8, 9999208, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 9, 9999209, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 10, 9999210, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 11, 9999211, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 12, 9999212, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 13, 9999213, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 14, 9999214, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 15, 9999215, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 16, 9999216, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 17, 9999217, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 18, 9999218, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 19, 9999219, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 20, 9999220, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 21, 9999221, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 22, 9999222, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 23, 9999223, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 24, 9999224, 99994);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 1, 9999301, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 2, 9999302, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 3, 9999303, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 4, 9999304, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999305, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999306, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 7, 9999307, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 8, 9999308, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 9, 9999309, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 10, 9999310, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 11, 9999311, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 12, 9999312, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 13, 9999313, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 14, 9999314, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 15, 9999315, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 16, 9999316, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 17, 9999317, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 18, 9999318, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 19, 9999319, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 20, 9999320, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 21, 9999321, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 22, 9999322, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 23, 9999323, 99995);
insert into survey_survey_question (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 24, 9999324, 99995);

insert into survey_answer (id, alt_text, text) 
values (9999201, 'Online courses', 'Online (including telecourse)');
insert into survey_answer (id, alt_text, text)
values (9999202, 'Face-to-face courses', 'Face-to-face courses');
insert into survey_answer (id, alt_text, text)
values (9999204, 'Not employed', 'Not employed');
insert into survey_answer (id, alt_text, text)
values (9999203, 'Hybrid / both', 'Hybrid (both online and face-to-face courses)');
insert into survey_answer (id, alt_text, text)
values (9999206, '11-19 hours', '11-19 hours');
insert into survey_answer (id, alt_text, text)
values (9999205, '1-10 hours', '1-10 hours');
insert into survey_answer (id, alt_text, text)
values (9999208, '25-30 hours', '25-30 hours');
insert into survey_answer (id, alt_text, text)
values (9999207, '20-25 hours', '20-25 hours');
insert into survey_answer (id, alt_text, text)
values (9999210, '35-40 hours', '35-40 hours');
insert into survey_answer (id, alt_text, text)
values (9999209, '30-35 hours', '30-35 hours');
insert into survey_answer (id, alt_text, text)
values (9999211, 'No childcare needed', 'No childcare needed');
insert into survey_answer (id, alt_text, text)
values (9999213, 'Offsite', 'Offsite');
insert into survey_answer (id, alt_text, text)
values (9999212, 'Onsite/Child Development Center', 'Onsite/Child Development Center');
insert into survey_answer (id, alt_text, text)
values (9999214, '< 15 miles', 'Less than 15 miles');
insert into survey_answer (id, alt_text, text)
values (9999215, '15-30 miles', '15-30 miles');
insert into survey_answer (id, alt_text, text)
values (9999216, '31-45 miles', '31-45 miles');
insert into survey_answer (id, alt_text, text)
values (9999217, '> 45 miles', 'More than 45 miles');
insert into survey_answer (id, alt_text, text)
values (9999218, 'Yes', 'Yes');
insert into survey_answer (id, alt_text, text)
values (9999219, 'No', 'No');
insert into survey_answer (id, alt_text, text)
values (9999220, 'Foster Youth?', 'I am a Foster Youth');
insert into survey_answer (id, alt_text, text)
values (9999221, 'Veteran', 'I am a Veteran');
insert into survey_answer (id, alt_text, text, help_text)
values (9999222, 'CalWORKs Student?', 'I am a CalWORKs Student', 'Need help text for CalWORKs');
insert into survey_answer (id, alt_text, text)
values (9999223, 'DSPS?', 'DSPS');
insert into survey_answer (id, alt_text, text)
values (9999224, 'EOPS?', 'EOPS');
insert into survey_answer (id, alt_text, text)
values (9999225, 'Clubs or Student Organizations', 'I am interested in joining a student organization or club');
insert into survey_answer (id, alt_text, text)
values (9999226, 'Tutoring Need', 'I am interested in tutoring services');
insert into survey_answer (id, alt_text, text)
values (9999227, 'Financial Aid?', 'I am interested in financial aid');

insert into survey_answer (id, alt_text, text)
values (9999301, 'Never', 'Never');
insert into survey_answer (id, alt_text, text)
values (9999302, 'Rarely', 'Rarely');
insert into survey_answer (id, alt_text, text)
values (9999303, 'Sometimes', 'Sometimes');
insert into survey_answer (id, alt_text, text)
values (9999304, 'Usually', 'Usually');

insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999101, 9999201, 'onlinecoursespreference');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999101, 9999202, 'face2facepreference');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (3, 9999101, 9999203, 'hybridcoursepreference');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999102, 9999205, 'work1-10');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999102, 9999204, 'nohoursworked');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (4, 9999102, 9999207, 'work20-25');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (3, 9999102, 9999206, 'work11-19');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (6, 9999102, 9999209, 'work30-35');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (5, 9999102, 9999208, 'work25-30');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, logic) 
values (2, 9999103, 9999212, 'onsitechildcareprefernce', 'POPUPTEXT|onsitechildcare,NOTIFICATION|childcare');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999103, 9999211, 'nochildcareneeded');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (7, 9999102, 9999210, 'work35-40');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, logic) 
values (3, 9999103, 9999213, 'offsitechildcarepreference', 'NOTIFICATION|childcare');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999104, 9999214, 'commuteLT15');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999104, 9999215, 'commute15_30');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (3, 9999104, 9999216, 'commute31_45');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (4, 9999104, 9999217, 'commuteOver45');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999105, 9999218, 'yesPublicTransport');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999105, 9999219, 'noPublicTransport');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999106, 9999218, 'yesRelocate');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999106, 9999219, 'noRelocate');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999107, 9999218, 'yesChangeCollege');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999107, 9999219, 'noChangeCollege');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (1, 9999108, 9999220, 'isFosterYouth');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (2, 9999108, 9999221, 'isVeteran');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (3, 9999108, 9999222, 'isCalWORKs');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (4, 9999108, 9999223, 'isDSPS');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (5, 9999108, 9999224, 'isEOPS');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (6, 9999108, 9999225, 'hasClubInterest');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (7, 9999108, 9999226, 'hasTutoringInterest');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name) 
values (8, 9999108, 9999227, 'hasFinancialAidInterest');

insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999201, 9999301, 'someoneTalkToNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999201, 9999302, 'someoneTalkToRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999201, 9999303, 'someoneTalkToSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999201, 9999304, 'someoneTalkToUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999202, 9999301, 'limitedCircleNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999202, 9999302, 'limitedCircleRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999202, 9999303, 'limitedCircleSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999202, 9999304, 'limitedCircleUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999203, 9999301, 'closePeopleNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999203, 9999302, 'closePeopleRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999203, 9999303, 'closePeopleSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999203, 9999304, 'closePeopleUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999204, 9999301, 'caringPeopleNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999204, 9999302, 'caringPeopleRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999204, 9999303, 'caringPeopleSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999204, 9999304, 'caringPeopleUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999205, 9999301, 'getOutNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999205, 9999302, 'getOutRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999205, 9999303, 'getOutSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999205, 9999304, 'getOutUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999206, 9999301, 'enjoyGettingPhysicalNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999206, 9999302, 'enjoyGettingPhysicalRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999206, 9999303, 'enjoyGettingPhysicalSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999206, 9999304, 'enjoyGettingPhysicalUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999207, 9999301, 'findTimeToBeActiveNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999207, 9999302, 'findTimeToBeActiveRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999207, 9999303, 'findTimeToBeActiveSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999207, 9999304, 'findTimeToBeActiveUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999208, 9999301, 'differentActivitiesNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999208, 9999302, 'differentActivitiesRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999208, 9999303, 'differentActivitiesSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999208, 9999304, 'differentActivitiesUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999209, 9999301, 'myThoughtsNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999209, 9999302, 'myThoughtsRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999209, 9999303, 'myThoughtsSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999209, 9999304, 'myThoughtsUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999210, 9999301, 'expressFeelingsNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999210, 9999302, 'expressFeelingsRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999210, 9999303, 'expressFeelingsSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999210, 9999304, 'expressFeelingsUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999211, 9999301, 'mindWandersNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999211, 9999302, 'mindWandersRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999211, 9999303, 'mindWandersSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999211, 9999304, 'mindWandersUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999212, 9999301, 'findWordsNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999212, 9999302, 'findWordsRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999212, 9999303, 'findWordsSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999212, 9999304, 'findWordsUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999213, 9999301, 'senseOfAccomplishmentNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999213, 9999302, 'senseOfAccomplishmentRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999213, 9999303, 'senseOfAccomplishmentSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999213, 9999304, 'senseOfAccomplishmentUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999214, 9999301, 'worldIsInterestingNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999214, 9999302, 'worldIsInterestingRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999214, 9999303, 'worldIsInterestingSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999214, 9999304, 'worldIsInterestingUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999215, 9999301, 'loveLearningNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999215, 9999302, 'loveLearningRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999215, 9999303, 'loveLearningSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999215, 9999304, 'loveLearningUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999216, 9999301, 'feelValuableNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999216, 9999302, 'feelValuableRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999216, 9999303, 'feelValuableSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999216, 9999304, 'feelValuableUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999217, 9999301, 'helpSomeoneNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999217, 9999302, 'helpSomeoneRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999217, 9999303, 'helpSomeoneSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999217, 9999304, 'helpSomeoneUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999218, 9999301, 'volunteerNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999218, 9999302, 'volunteerRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999218, 9999303, 'volunteerSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999218, 9999304, 'volunteerUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999219, 9999301, 'makeDifferenceNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999219, 9999302, 'makeDifferenceRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999219, 9999303, 'makeDifferenceSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999219, 9999304, 'makeDifferenceUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999220, 9999301, 'positiveVibesNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999220, 9999302, 'positiveVibesRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999220, 9999303, 'positiveVibesSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999220, 9999304, 'positiveVibesUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999221, 9999301, 'takeCareSelfNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999221, 9999302, 'takeCareSelfRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999221, 9999303, 'takeCareSelfSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999221, 9999304, 'takeCareSelfUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999222, 9999301, 'takeCareOfBodyNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999222, 9999302, 'takeCareOfBodyRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999222, 9999303, 'takeCareOfBodySometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999222, 9999304, 'takeCareOfBodyUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999223, 9999301, 'lifeBalanceNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999223, 9999302, 'lifeBalanceRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999223, 9999303, 'lifeBalanceSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999223, 9999304, 'lifeBalanceUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999224, 9999301, 'noRisksNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999224, 9999302, 'noRisksRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999224, 9999303, 'noRisksSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999224, 9999304, 'noRisksUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999301, 9999301, 'teamPlayerNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999301, 9999302, 'teamPlayerRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999301, 9999303, 'teamPlayerSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999301, 9999304, 'teamPlayerUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999302, 9999301, 'adaptableAtLearningNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999302, 9999302, 'adaptableAtLearningRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999302, 9999303, 'adaptableAtLearningSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999302, 9999304, 'adaptableAtLearningUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999303, 9999301, 'effectiveLearnerNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999303, 9999302, 'effectiveLearnerRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999303, 9999303, 'effectiveLearnerSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999303, 9999304, 'effectiveLearnerUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999304, 9999301, 'experimentWhenStuckNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999304, 9999302, 'experimentWhenStuckRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999304, 9999303, 'experimentWhenStuckSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999304, 9999304, 'experimentWhenStuckUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999305, 9999301, 'manageTimeNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999305, 9999302, 'manageTimeRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999305, 9999303, 'manageTimeSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999305, 9999304, 'manageTimeUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999306, 9999301, 'prioritisingNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999306, 9999302, 'prioritisingRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999306, 9999303, 'prioritisingSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999306, 9999304, 'prioritisingUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999307, 9999301, 'planSuccessNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999307, 9999302, 'planSuccessRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999307, 9999303, 'planSuccessSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999307, 9999304, 'planSuccessUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999308, 9999301, 'planAheadNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999308, 9999302, 'planAheadRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999308, 9999303, 'planAheadSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999308, 9999304, 'planAheadUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999309, 9999301, 'searchVarietyNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999309, 9999302, 'searchVarietyRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999309, 9999303, 'searchVarietySometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999309, 9999304, 'searchVarietyUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999310, 9999301, 'analyseQualityNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999310, 9999302, 'analyseQualityRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999310, 9999303, 'analyseQualitySometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999310, 9999304, 'analyseQualityUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999311, 9999301, 'groupInformationNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999311, 9999302, 'groupInformationRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999311, 9999303, 'groupInformationSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999311, 9999304, 'groupInformationUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999312, 9999301, 'originationNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999312, 9999302, 'originationRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999312, 9999303, 'originationSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999312, 9999304, 'originationUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999313, 9999301, 'opinionsBasedOnOthersNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999313, 9999302, 'opinionsBasedOnOthersRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999313, 9999303, 'opinionsBasedOnOthersSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999313, 9999304, 'opinionsBasedOnOthersUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999314, 9999301, 'incorporateMyWorkNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999314, 9999302, 'incorporateMyWorkRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999314, 9999303, 'incorporateMyWorkSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999314, 9999304, 'incorporateMyWorkUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999315, 9999301, 'rephraseNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999315, 9999302, 'rephraseRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999315, 9999303, 'rephraseSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999315, 9999304, 'rephraseUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999316, 9999301, 'understandingNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999316, 9999302, 'understandingRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999316, 9999303, 'understandingSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999316, 9999304, 'understandingUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999317, 9999301, 'academicEssayNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999317, 9999302, 'academicEssayRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999317, 9999303, 'academicEssaySometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999317, 9999304, 'academicEssayUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999318, 9999301, 'includeInAcademicWorkNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999318, 9999302, 'includeInAcademicWorkRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999318, 9999303, 'includeInAcademicWorkSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999318, 9999304, 'includeInAcademicWorkUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999319, 9999301, 'maxImpactNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999319, 9999302, 'maxImpactRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999319, 9999303, 'maxImpactSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999319, 9999304, 'maxImpactUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999320, 9999301, 'welcomeFeedbackNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999320, 9999302, 'welcomeFeedbackRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999320, 9999303, 'welcomeFeedbackSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999320, 9999304, 'welcomeFeedbackUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999321, 9999301, 'reviseNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999321, 9999302, 'reviseRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999321, 9999303, 'reviseSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999321, 9999304, 'reviseUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999322, 9999301, 'revisingConcurrentlyNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999322, 9999302, 'revisingConcurrentlyRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999322, 9999303, 'revisingConcurrentlySometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999322, 9999304, 'revisingConcurrentlyUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999323, 9999301, 'revisingMethodNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999323, 9999302, 'revisingMethodRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999323, 9999303, 'revisingMethodSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999323, 9999304, 'revisingMethodUsually');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (1, 9999324, 9999301, 'revisionIncludedNever');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (2, 9999324, 9999302, 'revisionIncludedRarely');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (3, 9999324, 9999303, 'revisionIncludedSometimes');
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name)
values (4, 9999324, 9999304, 'revisionIncludedUsually');

insert into survey_text (key, variant, alt_text, definition_text, help_text, text) 
values ('lifestyle_text', '', 'alt-text', 'def-text', 'help-text', 'survey-text');
insert into survey_text (key, variant, alt_text, definition_text, help_text, text) 
values ('onsitechildcare', '', 'On Site Childcare Notice', 'Click here for more information', 'What onsite means: blah blah', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');

insert into survey_response (id, user, survey_id)
values (9999336, 'admin', 99993);
insert into survey_response_answer (response_id, question_id)
values (9999336, 9999101);
insert into survey_response_answers (response_id, question_id, answer_id)
values (9999336, 9999101, 9999201);
insert into survey_response_answers (response_id, question_id, answer_id)
values (9999336, 9999101, 9999202);
insert into survey_response_answers (response_id, question_id, answer_id)
values (9999336, 9999101, 9999203);
insert into survey_response_answer (response_id, question_id)
values (9999336, 9999102);
insert into survey_response_answers (response_id, question_id, answer_id)
values (9999336, 9999102, 9999205);
insert into survey_response_answer (response_id, question_id)
values (9999336, 9999103);
insert into survey_response_answers (response_id, question_id, answer_id)
values (9999336, 9999103, 9999212);
