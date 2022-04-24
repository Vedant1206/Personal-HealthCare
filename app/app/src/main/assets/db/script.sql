CREATE TABLE MEMBER
    (ID INTEGER GENERATED BY DEFAULT AS IDENTITY(START WITH 1, INCREMENT BY 1),
     EMAIL VARCHAR(25) PRIMARY KEY, PASSWORD VARCHAR(26), IS_PATIENCE BOOLEAN DEFAULT TRUE NOT NULL);
CREATE TABLE PROFILES (EMAIL VARCHAR(25) NOT NULL, NAME VARCHAR(20) NOT NULL, ADDRESS VARCHAR(20) NOT NULL, HEIGHT INTEGER NOT NULL,
                        WEIGHT INTEGER NOT NULL, YEAR INTEGER NOT NULL, MONTH INTEGER NOT NULL, DAY INTEGER NOT NULL, SEX VARCHAR(2),
                        CONSTRAINT CONSTRAINT1 PRIMARY KEY(EMAIL, NAME));
ALTER TABLE PROFILES ADD FOREIGN KEY (EMAIL) REFERENCES MEMBER(EMAIL);
CREATE TABLE SYMPTOM( sympName varchar(100) not null, bodyPart varchar(50) not null, CONSTRAINT Symptom_PK PRIMARY KEY (sympName) );
CREATE TABLE CONDITION(
    name varchar(50) not null, srcName varchar(50) not null, srcLink varchar(200) not null, commonness int not null,
    description varchar(99999999) not null, CONSTRAINT Condition_PK PRIMARY KEY (name)
    );
CREATE TABLE CONDITION_SYMPTOMS
    ( condName varchar(50) not null, sympName varchar(100) not null,
    CONSTRAINT relation_PK PRIMARY KEY (condName, sympName),
    CONSTRAINT relation_FK1 FOREIGN KEY (condName) REFERENCES CONDITION(name),
    CONSTRAINT relation_FK2 FOREIGN KEY (sympName) REFERENCES SYMPTOM(sympName) );
INSERT INTO MEMBER (EMAIL, PASSWORD) VALUES ('email1@myumanitoba.ca', 'P@ssword123!');
INSERT INTO MEMBER (EMAIL, PASSWORD) VALUES ('email2@myumanitoba.ca', 'P@ssword123!');
INSERT INTO MEMBER (EMAIL, PASSWORD) VALUES ('email3@myumanitoba.ca', 'P@ssword123!');
INSERT INTO MEMBER (EMAIL, PASSWORD) VALUES ('email4@myumanitoba.ca', 'P@ssword123!');
INSERT INTO PROFILES VALUES('email1@myumanitoba.ca', 'James', 'Street1 City1', 180, 70, 2000, 12, 31, 'M');
INSERT INTO PROFILES VALUES('email1@myumanitoba.ca', 'Isabella', 'Street1 City1', 162, 55, 1999, 5, 1, 'F');
INSERT INTO PROFILES VALUES('email1@myumanitoba.ca', 'Benjamin', 'Street3 City4', 180, 80, 2000, 9, 15, 'M');
INSERT INTO PROFILES VALUES('email2@myumanitoba.ca', 'Mia', 'Street2 City2', 155, 40, 1992, 12, 31, 'F');
INSERT INTO PROFILES VALUES('email2@myumanitoba.ca', 'Lucas', 'Street12 City15', 172, 66, 2002, 3, 20, 'M');
INSERT INTO PROFILES VALUES('email3@myumanitoba.ca', 'Evelyn', 'Street6 City7', 168, 55, 1997, 11, 2, 'F');
INSERT INTO PROFILES VALUES('email4@myumanitoba.ca', 'Alexander', 'Street16 City81', 180, 98, 2000, 12, 31, 'M');
INSERT INTO CONDITION VALUES ('Acne', 'MayoClinic', 'https://www.mayoclinic.org/diseases-conditions/acne/symptoms-causes/syc-20368047', 1, 'Acne is a skin condition that occurs when your hair follicles become plugged with oil and dead skin cells. It causes whiteheads, blackheads or pimples. Acne is most common among teenagers, though it affects people of all ages.<br>Effective acne treatments are available, but acne can be persistent. The pimples and bumps heal slowly, and when one begins to go away, others seem to crop up.<br>Depending on its severity, acne can cause emotional distress and scar the skin. The earlier you start treatment, the lower your risk of such problems.<br>');
INSERT INTO CONDITION VALUES ('Acid reflux (Gerd)', 'MayoClinic', 'https://www.mayoclinic.org/diseases-conditions/gerd/symptoms-causes/syc-20361940', 0, 'Gastroesophageal reflux disease (GERD) occurs when stomach acid frequently flows back into the tube connecting your mouth and stomach (esophagus). This backwash (acid reflux) can irritate the lining of your esophagus.<br>Many people experience acid reflux from time to time. GERD is mild acid reflux that occurs at least twice a week, or moderate to severe acid reflux that occurs at least once a week.<br>');
INSERT INTO CONDITION VALUES ('Hangover','MayoClinic','https://www.mayoclinic.org/diseases-conditions/hangovers/symptoms-causes/syc-20373012', 1, 'A hangover is a group of unpleasant signs and symptoms that can develop after drinking too much alcohol. As if feeling awful were not bad enough, frequent hangovers are also associated with poor performance and conflict at work.<br>As a general rule, the more alcohol you drink, the more likely you are to have a hangover the next day. But there is no magic formula to tell you how much you can safely drink and still avoid a hangover.<br>');
INSERT INTO CONDITION VALUES ('Anemia','MayoClinic','https://www.mayoclinic.org/diseases-conditions/anemia/symptoms-causes/syc-20351360', 0, 'Anemia is a condition in which you lack enough healthy red blood cells to carry adequate oxygen to your bodys tissues. Having anemia, also referred to as low hemoglobin, can make you feel tired and weak.<br>There are many forms of anemia, each with its own cause. Anemia can be temporary or long term and can range from mild to severe. In most cases, anemia has more than one cause. See your doctor if you suspect that you have anemia. It can be a warning sign of serious illness.<br>');
INSERT INTO CONDITION VALUES ('PMS','WebMD','https://www.webmd.com/cold-and-flu/features/cold-sinus-infections',1, 'PMS affects almost all women to some degree during their reproductive years. <br>PMS is a catch-all name for a myriad of physical and psychological symptoms, it is thought to be caused by hormonal changes during the menstrual cycle. The exact cause, however, remains a mystery. Symptoms generally strike five-to-10 days before the period and dissipate with its start or soon after. Research has determined that women are not imagining anything -- and, thankfully, there is help.<br>');
INSERT INTO CONDITION VALUES ('Cold','WebMD','https://www.webmd.com/women/pms/features/pms-signs-symptoms', 1, 'If it’s a cold virus, you may find yourself close to a tissue box for several days. Most of the time, colds get better on their own in 10 days or less.<br>Because the common cold is a virus, antibiotics won’t help. But over-the-counter medications may make you feel better. <br>“The remedies you choose should be targeted at specific symptoms, so something for your headache, for your congestion, for your fever,” says Camelia Davtyan, MD, a professor of medicine at UCLA. <br>');
INSERT INTO CONDITION VALUES ('Chalazion','MedlinePlus','https://medlineplus.gov/ency/article/001006.htm', 1, 'A chalazion is a small bump in the eyelid caused by a blockage of a tiny oil gland. <br>A chalazion often develops following an internal hordeolum (also called a stye). The eyelid most often becomes tender, red, swollen and warm. Sometimes, the blocked gland causing the stye will not drain even though the redness and swelling go away. The gland will form a firm nodule in the eyelid that is not tender. This is called a chalazion. <br>');
INSERT INTO CONDITION VALUES ('Arthritis','MedlinePlus','https://medlineplus.gov/ency/article/001243.htm', 0, 'Arthritis is inflammation or degeneration of one or more joints. A joint is the area where 2 bones meet. There are more than 100 different types of arthritis.<br>Arthritis involves the breakdown of structures of the joint, particularly cartilage. Normal cartilage protects a joint and allows it to move smoothly. Cartilage also absorbs shock when pressure is placed on the joint, such as when you walk. Without the normal amount of cartilage, the bones under the cartilage become damaged and rub together. This causes swelling (inflammation), and stiffness.<br>');
INSERT INTO SYMPTOM VALUES ('whiteheads','head');
INSERT INTO SYMPTOM VALUES ('blackheads','head');
INSERT INTO SYMPTOM VALUES ('small bumps','head');
INSERT INTO SYMPTOM VALUES ('pimples','head');
INSERT INTO SYMPTOM VALUES ('heartburn','chest');
INSERT INTO SYMPTOM VALUES ('chest pain','chest');
INSERT INTO SYMPTOM VALUES ('difficulty swallowing','chest');
INSERT INTO SYMPTOM VALUES ('fatigue','chest');
INSERT INTO SYMPTOM VALUES ('excessive thirst','stomach');
INSERT INTO SYMPTOM VALUES ('Nausea','stomach');
INSERT INTO SYMPTOM VALUES ('headache','head');
INSERT INTO SYMPTOM VALUES ('shakiness','chest');
INSERT INTO SYMPTOM VALUES ('weakness','head');
INSERT INTO SYMPTOM VALUES ('pale skin','chest');
INSERT INTO SYMPTOM VALUES ('Cold hands','arms');
INSERT INTO SYMPTOM VALUES ('dizziness','head');
INSERT INTO SYMPTOM VALUES ('moodiness','stomach');
INSERT INTO SYMPTOM VALUES ('abdominal cramping','stomach');
INSERT INTO SYMPTOM VALUES ('food cravings','stomach');
INSERT INTO SYMPTOM VALUES ('bloating','stomach');
INSERT INTO SYMPTOM VALUES ('breast tenderness','chest');
INSERT INTO SYMPTOM VALUES ('Sore throat ','head');
INSERT INTO SYMPTOM VALUES ('Stuffy nose','head');
INSERT INTO SYMPTOM VALUES ('Swollen sinuses','head');
INSERT INTO SYMPTOM VALUES ('Headache','head');
INSERT INTO SYMPTOM VALUES ('Sneezing','head');
INSERT INTO SYMPTOM VALUES ('bump on eyelid','head');
INSERT INTO SYMPTOM VALUES ('eye irritation','head');
INSERT INTO SYMPTOM VALUES ('blurry vision','head');
INSERT INTO SYMPTOM VALUES ('Joint pain','arms');
INSERT INTO SYMPTOM VALUES ('joint swelling','arms');
INSERT INTO SYMPTOM VALUES ('joint stiffness','arms');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acne','whiteheads');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acne','blackheads');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acne','small bumps');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acne','pimples');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acid reflux (Gerd)','heartburn');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acid reflux (Gerd)','chest pain');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Acid reflux (Gerd)','difficulty swallowing');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Hangover','fatigue');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Hangover','excessive thirst');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Hangover','Nausea');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Hangover','headache');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Hangover','shakiness');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Anemia','fatigue');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Anemia','weakness');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Anemia','pale skin');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Anemia','Cold hands');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Anemia','dizziness');
INSERT INTO CONDITION_SYMPTOMS VALUES ('PMS','moodiness');
INSERT INTO CONDITION_SYMPTOMS VALUES ('PMS','abdominal cramping');
INSERT INTO CONDITION_SYMPTOMS VALUES ('PMS','food cravings');
INSERT INTO CONDITION_SYMPTOMS VALUES ('PMS','bloating');
INSERT INTO CONDITION_SYMPTOMS VALUES ('PMS','breast tenderness');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','Sore throat ');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','Stuffy nose');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','Swollen sinuses');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','fatigue');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','Headache');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Cold','Sneezing');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Chalazion','bump on eyelid');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Chalazion','eye irritation');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Chalazion','blurry vision');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Arthritis','Joint pain');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Arthritis','joint swelling');
INSERT INTO CONDITION_SYMPTOMS VALUES ('Arthritis','joint stiffness');