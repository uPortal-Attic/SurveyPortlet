# Administering the Survey Portlet

Use the following steps to create an survey that you can add to your portal:

1. Navigate to *Survey Admin tab* -> Add Survey button to display a new set of **Edit Survey** and **Preview Survey** buttons
2. Click the **Edit Survey** button to display the *Title*, *Description*, and *Unique Name* fields, as well as the **Add Question**, **Save Survey**, and **Publish Survey** buttons
3. Enter values in the *Title* field to create the title for your Survey
4. Click the **Add Question** button to add a new, blank question at the end of the survey's field group.
5. Click the **Open Question 1** button to display the *Survey Administration Question* field group and enter information for the question and its answer
    1. Enter the survey question text in the **Question** Text field.
    2. Optional Step: Enter a value in the *Help Text* field. This is an optional field but the value you enter provide additional details/help displayed to the user’s UI.
    3. Enter the number of answers/responses allowed for the question in the *Allowed Answers* field.
    4. Click the **Add** button next to the Answers label to display an *answer* field.
6. Optional Step: Click the **Open** button on the far right of the *answer* field to display the *Survey Administration Answer* field group and enter information for the answer.
    1. Edit the *Answer Text* field if needed. The content entered in the *Answer* field from step 5 will appear in the *Answer Text* field.
    2. Enter a value in the *Help Text* field. This is an optional field but the value you enter provide additional details/help displayed in the users’ UI.
    3. Select the *Show an image* checkbox to display the *Image URL* field, *Image Alternate Text* field, *Image Height* field, and *Image Width* field.
    4. Enter an image URL in the *Image URL* field to display the image next to the corresponding answer.
    5. Populate the *Image Alternate Text* field.
    6. Enter a numeric value in the *Image Height* field for the image height.  
    7. Enter a numeric value in the *Image Width* field for the image width.
    8. Edit the *Unique Name* field.
    9. Enter and format the content you want displayed at the end of the survey to users who select this answer.
7. Optional Step: Click the **Add** button on the right of **Actions** to add an action and display the *Action Type* drop-down list.
    1. Click **Add** as many times as needed to add additional actions to the answer.
    2. Click the green **Up** and **Down** buttons on the right to select the order in which the actions are organized,  
    3. Click the **Delete** button on the right to remove an action.
8. Optional Step: Click the **Add** button on the right of Follow-up Question to display the *Question* text field.
9. When you complete the configuration for a survey answer, click **Save Survey** to save your changes.
10. Click **Back to Surveys** to return to the Surveys portlet where you can:
    * Click **Edit  Survey** for  your  survey  if  you  want  to  make  any  more  changes  (add  more questions/answers, format any questions, etc.).
    * Click **Preview Survey** to see a preview of the survey you just created.
11. When your survey is complete and you are ready to publish it, click **Publish Survey**. You may see a pop-up dialog box that prompts you to confirm publication of the survey. The text (Published) appears after your survey title.
12. Once the survey has been completed, you must register it:
    1. Register the survey portlet: Tenant Admin tab -> Tenant Portal Administration panel -> Mange Portlets link -> **Register New Portlet** button -> Portlet radio button and click the **Continue** button to open the Summary Information screen.
    2. Select/survey-portlet from the first drop-down list.
    3. Select *survey-portlet* from the second drop-down list.
    4. Click **Continue** to display the Summary Information screen.
    5. The *Portlet Title* and *Portlet Name* field values are auto-populated by default. Overwrite these default values with a unique name. The *Portlet Title* and *Portlet Name* should generally be the same.
    6. Enter a value in the *Portlet Functional Name* field. The name of your survey is a good choice here.
    7. Click **Continue** to display the Summary Information screen.
    8. The *Portlet Title* and *Portlet Name* field values are auto-populated by default. Overwrite these default values with a unique name. The Portlet Title and Portlet Name should generally be the same.
    9. Enter a value in the *Portlet Functional Name* field. The name of your survey is a good choice here.
    10. The *Portlet Description* field is optional, but you can enter a value here that describes your survey portlet which may be helpful.
    11. Click the **Advanced Options** link -> **Add Preference** button to open the *Add Preference* dialog box.
    12. Enter surveyName in the *Preference Name* field and click **Add**  to create a new Portlet Preference row
    13. Enter the Unique Name value from step 3 above in the *Value* field.
    14. Scroll down and click the **Edit Principals** and **Edit Categories** buttons to add groups and categories for the survey.
    15. Choose the Lifecycle Management option (*Created*, *Approved*, *Published*, *Expired* or *Maintenance*) for your survey and click **Save**.

Once your survey portlet has been successfully registered, a success confirmation message displays along with a link to Manage DLM Fragments.
