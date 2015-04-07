insert into "public"."survey_survey" (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99991, 'Test Survey 1 description', 's1_text', now(), 'admin', 0, 'Test Survey 1', 'sur1');
insert into "public"."survey_survey" (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99992, 'Test Survey 2 description', 's2_text', now(), 'admin', 0, 'Test Survey 2', 'sur2');
insert into "public"."survey_survey" (id, description, text_key, last_update_date, last_update_user, status, title, canonical_name) 
values (99993, 'CCC Lifestyle Survey', 'lifestyle_text', now(), 'admin', 0, 'Lifestyle Survey', 'lifestyle');

insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999101, 'Course types desired', 0, 'Indicate the types of courses you desire to take', 'courseType');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999102, 'Employment Status', 0, 'Please indicate the number of hours you are currently employed','employmentStatus');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999103, 'Childcare needed', 0, 'Please indicate the type of childcare needed to attend college', 'childcare');

insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (2, 1, 9999101, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 2, 9999102, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 3, 9999103, 99993);

insert into "public"."survey_text" (key, variant, alt_text, definition_text, help_text, text) 
values ('lifestyle_text', '', 'alt-text', 'def-text', 'help-text', 'survey-text');
insert into "public"."survey_text" (key, variant, alt_text, definition_text, help_text, text) 
values ('onsitechildcare', '', 'On Site Childcare Notice', 'Click here for more information', 'What onsite means: blah blah', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');


insert into "public"."survey_answer" (id, alt_text, text)
values (9999202, 'Face-to-face courses', 'Face-to-face courses');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999204, 'Not employed', 'Not employed');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999203, 'Hybrid / both', 'Hybrid (both online and face-to-face courses)');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999206, '11-19 hours', '11-19 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999205, '1-10 hours', '1-10 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999208, '25-30 hours', '25-30 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999207, '20-25 hours', '20-25 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999210, '35-40 hours', '35-40 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999209, '30-35 hours', '30-35 hours');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999211, 'No childcare needed', 'No childcare needed');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999213, 'Offsite', 'Offsite');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999212, 'Onsite/Child Development Center', 'Onsite/Child Development Center');
insert into "public"."survey_answer" (id, alt_text, text) 
values (9999201, 'Online courses', 'Online (including telecourse)');


insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999101, 9999201, 'onlinecoursespreference');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999101, 9999202, 'face2facepreference');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (3, 9999101, 9999203, 'hybridcoursepreference');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999102, 9999205, 'work1-10');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999102, 9999204, 'nohoursworked');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (4, 9999102, 9999207, 'work20-25');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (3, 9999102, 9999206, 'work11-19');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (6, 9999102, 9999209, 'work30-35');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (5, 9999102, 9999208, 'work25-30');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name, logic) 
values (2, 9999103, 9999212, 'onsitechildcareprefernce', 'POPUPTEXT|onsitechildcare,NOTIFICATION|childcare');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999103, 9999211, 'nochildcareneeded');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (7, 9999102, 9999210, 'work35-40');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name, logic) 
values (3, 9999103, 9999213, 'offsitechildcarepreference', 'NOTIFICATION|childcare');
