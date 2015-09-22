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
values (9999201, 'Someone to talk to', 0, 'There is  someone I can talk to about my personal problems', 'someoneTalkTo');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999202, 'I have enough friends', 0, 'I feel that I have enough friends and acquaintances in my life', 'enoughFriends');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999203, 'Not enough time with others', 0, 'I feel like I don''t spend enough time doing things with others', 'closePeople');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999204, 'People care about me', 0, 'I feel there are people in my life who really care about me', 'caringPeople');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999205, 'I get out', 0, 'I get out and about in the open air enough', 'getOut');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999206, 'I dislike physical activity', 0, 'I dislike physical activities like walking, gardening, dancing', 'dislikePhysical');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999207, 'I find time to be active', 0, 'Being physically active is part of my daily routine', 'findTimeToBeActive');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999208, 'I do different activities', 0, 'I get involved in different sports and physical activities', 'differentActivities');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999209, 'I know my thoughts', 0, 'I am aware of what thoughts are passing through my mind', 'myThoughts');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999210, 'I cannot express my feelings', 0, 'I find it hard to find words to describe my feelings', 'expressFeelings');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999211, 'I can focus', 0, 'I can focus on what I need to do without getting distracted', 'noDistractions');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999212, 'I take notice of my surroundings', 0, 'I take time to notice what''s going on around me', 'takeNotice');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999213, 'I feel accomplishment', 0, 'I feel a sense of accomplishment from the tings I do', 'senseOfAccomplishment');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999214, 'I am bored', 0, 'I find my day to day life boring', 'boring');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999215, 'I enjoy learning', 0, 'I love discovering and trying new things', 'loveDiscovering');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999216, 'I do fun things', 0, 'I like doing things just for fun', 'justForFun');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999217, 'I help others', 0, 'I feel that I help others in big or small ways', 'helpOthers');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999218, 'I volunteer', 0, 'I am happy to volunteer my time to help others', 'volunteer');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999219, 'I make a difference', 0, 'I feel that I make a positive difference to other people’s lives', 'makeDifference');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999220, 'I am unkind', 0, 'I find it hard to be kind and positive to others', 'hardToBeKind');

insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999221, 'I take care of myself', 0, 'I take good care of myself physically', 'takeCareSelf');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999222, 'I take risks', 0, 'I take dangerous risks with my safetly or my health', 'takeRisks');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999223, 'I have balance', 0, 'I have a good work/life balance', 'lifeBalance');
insert into survey_question (id, alt_text, status, text, canonical_name)
values (9999224, 'I take care of my mental state', 0, 'I make a real effort to look after my mental health', 'makeEffort');

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

insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999201, 9999301, 'someoneTalkToNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999201, 9999302, 'someoneTalkToRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999201, 9999303, 'someoneTalkToSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999201, 9999304, 'someoneTalkToUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999202, 9999301, 'enoughFriendsNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999202, 9999302, 'enoughFriendsRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999202, 9999303, 'enoughFriendsSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999202, 9999304, 'enoughFriendsUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999203, 9999301, 'closePeopleNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999203, 9999302, 'closePeopleRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999203, 9999303, 'closePeopleSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999203, 9999304, 'closePeopleUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999204, 9999301, 'caringPeopleNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999204, 9999302, 'caringPeopleRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999204, 9999303, 'caringPeopleSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999204, 9999304, 'caringPeopleUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999205, 9999301, 'getOutNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999205, 9999302, 'getOutRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999205, 9999303, 'getOutSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999205, 9999304, 'getOutUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999206, 9999301, 'dislikePhysicalNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999206, 9999302, 'dislikePhysicalRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999206, 9999303, 'dislikePhysicalSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999206, 9999304, 'dislikePhysicalUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999207, 9999301, 'findTimeToBeActiveNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999207, 9999302, 'findTimeToBeActiveRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999207, 9999303, 'findTimeToBeActiveSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999207, 9999304, 'findTimeToBeActiveUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999208, 9999301, 'differentActivitiesNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999208, 9999302, 'differentActivitiesRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999208, 9999303, 'differentActivitiesSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999208, 9999304, 'differentActivitiesUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999209, 9999301, 'myThoughtsNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999209, 9999302, 'myThoughtsRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999209, 9999303, 'myThoughtsSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999209, 9999304, 'myThoughtsUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999210, 9999301, 'expressFeelingsNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999210, 9999302, 'expressFeelingsRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999210, 9999303, 'expressFeelingsSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999210, 9999304, 'expressFeelingsUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999211, 9999301, 'noDistractionsNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999211, 9999302, 'noDistractionsRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999211, 9999303, 'noDistractionsSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999211, 9999304, 'noDistractionsUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999212, 9999301, 'takeNoticeNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999212, 9999302, 'takeNoticeRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999212, 9999303, 'takeNoticeSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999212, 9999304, 'takeNoticeUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999213, 9999301, 'senseOfAccomplishmentNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999213, 9999302, 'senseOfAccomplishmentRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999213, 9999303, 'senseOfAccomplishmentSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999213, 9999304, 'senseOfAccomplishmentUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999214, 9999301, 'boringNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999214, 9999302, 'boringRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999214, 9999303, 'boringSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999214, 9999304, 'boringUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999215, 9999301, 'loveDiscoveringNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999215, 9999302, 'loveDiscoveringRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999215, 9999303, 'loveDiscoveringSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999215, 9999304, 'loveDiscoveringUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999216, 9999301, 'justForFunNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999216, 9999302, 'justForFunRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999216, 9999303, 'justForFunSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999216, 9999304, 'justForFunUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999217, 9999301, 'helpOthersNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999217, 9999302, 'helpOthersRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999217, 9999303, 'helpOthersSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999217, 9999304, 'helpOthersUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999218, 9999301, 'volunteerNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999218, 9999302, 'volunteerRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999218, 9999303, 'volunteerSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999218, 9999304, 'volunteerUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999219, 9999301, 'makeDifferenceNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999219, 9999302, 'makeDifferenceRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999219, 9999303, 'makeDifferenceSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999219, 9999304, 'makeDifferenceUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999220, 9999301, 'hardToBeKindsNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999220, 9999302, 'hardToBeKindsRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999220, 9999303, 'hardToBeKindsSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999220, 9999304, 'hardToBeKindsUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999221, 9999301, 'takeCareSelfNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999221, 9999302, 'takeCareSelfRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999221, 9999303, 'takeCareSelfSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999221, 9999304, 'takeCareSelfUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999222, 9999301, 'takeRisksNever', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999222, 9999302, 'takeRisksRarely', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999222, 9999303, 'takeRisksSometimes', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999222, 9999304, 'takeRisksUsually', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999223, 9999301, 'lifeBalanceNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999223, 9999302, 'lifeBalanceRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999223, 9999303, 'lifeBalanceSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999223, 9999304, 'lifeBalanceUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999224, 9999301, 'makeEffortNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999224, 9999302, 'makeEffortRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999224, 9999303, 'makeEffortSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999224, 9999304, 'makeEffortUsually', 3);

insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999301, 9999301, 'teamPlayerNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999301, 9999302, 'teamPlayerRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999301, 9999303, 'teamPlayerSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999301, 9999304, 'teamPlayerUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999302, 9999301, 'adaptableAtLearningNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999302, 9999302, 'adaptableAtLearningRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999302, 9999303, 'adaptableAtLearningSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999302, 9999304, 'adaptableAtLearningUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999303, 9999301, 'effectiveLearnerNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999303, 9999302, 'effectiveLearnerRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999303, 9999303, 'effectiveLearnerSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999303, 9999304, 'effectiveLearnerUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999304, 9999301, 'experimentWhenStuckNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999304, 9999302, 'experimentWhenStuckRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999304, 9999303, 'experimentWhenStuckSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999304, 9999304, 'experimentWhenStuckUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999305, 9999301, 'manageTimeNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999305, 9999302, 'manageTimeRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999305, 9999303, 'manageTimeSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999305, 9999304, 'manageTimeUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999306, 9999301, 'prioritisingNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999306, 9999302, 'prioritisingRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999306, 9999303, 'prioritisingSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999306, 9999304, 'prioritisingUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999307, 9999301, 'planSuccessNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999307, 9999302, 'planSuccessRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999307, 9999303, 'planSuccessSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999307, 9999304, 'planSuccessUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999308, 9999301, 'planAheadNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999308, 9999302, 'planAheadRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999308, 9999303, 'planAheadSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999308, 9999304, 'planAheadUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999309, 9999301, 'searchVarietyNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999309, 9999302, 'searchVarietyRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999309, 9999303, 'searchVarietySometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999309, 9999304, 'searchVarietyUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999310, 9999301, 'analyseQualityNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999310, 9999302, 'analyseQualityRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999310, 9999303, 'analyseQualitySometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999310, 9999304, 'analyseQualityUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999311, 9999301, 'groupInformationNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999311, 9999302, 'groupInformationRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999311, 9999303, 'groupInformationSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999311, 9999304, 'groupInformationUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999312, 9999301, 'originationNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999312, 9999302, 'originationRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999312, 9999303, 'originationSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999312, 9999304, 'originationUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999313, 9999301, 'opinionsBasedOnOthersNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999313, 9999302, 'opinionsBasedOnOthersRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999313, 9999303, 'opinionsBasedOnOthersSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999313, 9999304, 'opinionsBasedOnOthersUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999314, 9999301, 'incorporateMyWorkNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999314, 9999302, 'incorporateMyWorkRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999314, 9999303, 'incorporateMyWorkSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999314, 9999304, 'incorporateMyWorkUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999315, 9999301, 'rephraseNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999315, 9999302, 'rephraseRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999315, 9999303, 'rephraseSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999315, 9999304, 'rephraseUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999316, 9999301, 'understandingNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999316, 9999302, 'understandingRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999316, 9999303, 'understandingSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999316, 9999304, 'understandingUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999317, 9999301, 'academicEssayNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999317, 9999302, 'academicEssayRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999317, 9999303, 'academicEssaySometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999317, 9999304, 'academicEssayUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999318, 9999301, 'includeInAcademicWorkNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999318, 9999302, 'includeInAcademicWorkRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999318, 9999303, 'includeInAcademicWorkSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999318, 9999304, 'includeInAcademicWorkUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999319, 9999301, 'maxImpactNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999319, 9999302, 'maxImpactRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999319, 9999303, 'maxImpactSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999319, 9999304, 'maxImpactUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999320, 9999301, 'welcomeFeedbackNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999320, 9999302, 'welcomeFeedbackRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999320, 9999303, 'welcomeFeedbackSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999320, 9999304, 'welcomeFeedbackUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999321, 9999301, 'reviseNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999321, 9999302, 'reviseRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999321, 9999303, 'reviseSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999321, 9999304, 'reviseUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999322, 9999301, 'revisingConcurrentlyNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999322, 9999302, 'revisingConcurrentlyRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999322, 9999303, 'revisingConcurrentlySometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999322, 9999304, 'revisingConcurrentlyUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999323, 9999301, 'revisingMethodNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999323, 9999302, 'revisingMethodRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999323, 9999303, 'revisingMethodSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999323, 9999304, 'revisingMethodUsually', 3);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (1, 9999324, 9999301, 'revisionIncludedNever', 0);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (2, 9999324, 9999302, 'revisionIncludedRarely', 1);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (3, 9999324, 9999303, 'revisionIncludedSometimes', 2);
insert into survey_question_answer (sequence, question_id, answer_id, canonical_name, value)
values (4, 9999324, 9999304, 'revisionIncludedUsually', 3);

insert into survey_text (text_key, variant, alt_text, definition_text, help_text, text)
values ('lifestyle_text', '', 'alt-text', 'def-text', 'help-text', 'survey-text');
insert into survey_text (text_key, variant, alt_text, definition_text, help_text, text)
values ('onsitechildcare', '', 'On Site Childcare Notice', 'Click here for more information', 'What onsite means: blah blah', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.');
