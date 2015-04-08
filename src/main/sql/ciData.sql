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
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999104, 'Willing Commute Distance', 0, 'How far would you commute in order to attend college?', 'commuteDistance');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999105, 'Commute Transportation', 0, 'Will you be using public transportation to attend college?', 'commutePublicTransport');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999106, 'Relocate in order to attend?', 0, 'Are you willing to relocate to attend college?', 'commuteRelocate');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999107, 'Change college based on interests?', 0, 'Are you willing to change your college choice based on your needs and interests?', 'changeBasedOnInterests');
insert into "public"."survey_question" (id, alt_text, status, text, canonical_name) 
values (9999108, 'Select all that apply', 0, 'Please select all of the following that apply to you:', 'studentAtrributes');

insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (2, 1, 9999101, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 2, 9999102, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 3, 9999103, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 4, 9999104, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999105, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999106, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 5, 9999107, 99993);
insert into "public"."survey_survey_question" (num_allowed_answers, sequence, question_id, survey_id) 
values (1, 6, 9999108, 99993);

insert into "public"."survey_answer" (id, alt_text, text) 
values (9999201, 'Online courses', 'Online (including telecourse)');
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
values (9999214, '< 15 miles', 'Less than 15 miles');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999215, '15-30 miles', '15-30 miles');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999216, '31-45 miles', '31-45 miles');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999217, '> 45 miles', 'More than 45 miles');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999218, 'Yes', 'Yes');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999219, 'No', 'No');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999220, 'Foster Youth?', 'I am a Foster Youth');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999221, 'Veteran', 'I am a Veteran');
insert into "public"."survey_answer" (id, alt_text, text, help_text)
values (9999222, 'CalWORKs Student?', 'I am a CalWORKs Student', 'Need help text for CalWORKs');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999223, 'DSPS?', 'DSPS');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999224, 'EOPS?', 'EOPS');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999225, 'Clubs or Student Organizations', 'I am interested in joining a student organization or club');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999226, 'Tutoring Need', 'I am interested in tutoring services');
insert into "public"."survey_answer" (id, alt_text, text)
values (9999227, 'Financial Aid?', 'I am interested in financial aid');

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
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999104, 9999214, 'commuteLT15');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999104, 9999215, 'commute15_30');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (3, 9999104, 9999216, 'commute31_45');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (4, 9999104, 9999217, 'commuteOver45');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999105, 9999218, 'yesPublicTransport');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999105, 9999219, 'noPublicTransport');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999106, 9999218, 'yesRelocate');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999106, 9999219, 'noRelocate');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999107, 9999218, 'yesChangeCollege');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999107, 9999219, 'noChangeCollege');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (1, 9999108, 9999220, 'isFosterYouth');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (2, 9999108, 9999221, 'isVeteran');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (3, 9999108, 9999222, 'isCalWORKs');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (4, 9999108, 9999223, 'isDSPS');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (5, 9999108, 9999224, 'isEOPS');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (6, 9999108, 9999225, 'hasClubInterest');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (7, 9999108, 9999226, 'hasTutoringInterest');
insert into "public"."survey_question_answer" (sequence, question_id, answer_id, canonical_name) 
values (8, 9999108, 9999227, 'hasFinancialAidInterest');

insert into "public"."survey_text" (key, variant, alt_text, definition_text, help_text, text) 
values ('lifestyle_text', '', 'alt-text', 'def-text', 'help-text', 'survey-text');
insert into "public"."survey_text" (key, variant, alt_text, definition_text, help_text, text) 
values ('onsitechildcare', '', 'On Site Childcare Notice', 'Click here for more information', 'What onsite means: blah blah', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');
