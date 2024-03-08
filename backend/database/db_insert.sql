USE FirstStepApp
GO

BEGIN TRANSACTION
	INSERT INTO Universities(name, img) VALUES ('Universitatea Babes-Bolyai', 'https://andrei-forminte.online/project/ubb.png');
	INSERT INTO Universities(name, img) VALUES ('Universitatea Tehnica din Cluj-Napoca', 'https://andrei-forminte.online/project/utcn.png');
	INSERT INTO Universities(name, img) VALUES ('Universitatea de Medicina si Farmacie Iuliu Hatieganu', 'https://andrei-forminte.online/project/umf.png');
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Matematica si Informatica', 1);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Drept', 1);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Stiinte Economice si Gestiunea Afacerilor', 1);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Automatica si Calculatoare');
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Constructii', 2);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Electronica, Telecomunicatii si Tehnologia Informatiei', 2);
	INSERT INTO Faculties(name, university) VALUES('Facultatea Medicina', 3);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Medicina Dentara', 3);
	INSERT INTO Faculties(name, university) VALUES('Facultatea de Farmacie', 3);
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Incasarea taxelor pentru examenele restante din sesiunea de IARNA (inclusiv studentii aflati in prelungire de studii)', 'Plati Examene - Studenti Anii II si III, Masteranzi Anul II! pentru Sesiunea Ianuarie-Februarie 2024', 1, 1, 'https://www.cs.ubbcluj.ro/incasarea-taxelor-pentru-examenele-restante-din-sesiunea-de-iarna-inclusiv-studentii-aflati-in-prelungire-de-studii/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('InnoHack – Students Hackathon @ CS InnoHUB', ' Participa la InnoHack: Eveniment de Inovatie si Tehnologie pentru a Transforma Ideilor in Solutii Pratice!', 1, 1, 'https://www.cs.ubbcluj.ro/innohack-students-hackathon-cs-innohub/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Destresiune, editia 2023', 'Evenimentul Destresiune: Weekend distractiv cu activitati tropicale, inclusiv Bingo Muzical, Quiz Night, Q&A, Beerpong, Escape Room, si stand-up.', 1, 1, 'https://www.cs.ubbcluj.ro/destresiune-editia-2023/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Liste finale burse, sem. I/2023-2024', 'Listele finale de burse s-au afisat astazi, 14 noiembrie 2023, ora 12,15', 1, 2, 'https://law.ubbcluj.ro/index.php?option=com_content&view=article&id=5815:liste-finale-burse-sem-i-2023-2024&catid=8&Itemid=107');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Solutionare contestatii burse sem. I/2023-2024', 'Solutionarea contestatiilor privind modul de acordare a burselor pentru semestrul I/2023-2024', 1, 2, 'https://law.ubbcluj.ro/index.php?option=com_content&view=article&id=5814:solutionare-contestatii-burse-sem-i-2023-2024&catid=8&Itemid=107');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Liste provizorii burse sem. I/2023-2024', 'Bursele (liste provizorii) au fost afisate, astazi, 6 noiembrie 2023.', 1, 2, 'https://law.ubbcluj.ro/index.php?option=com_content&view=article&id=5808:liste-provizorii-burse-sem-i-2023-2024&catid=8&Itemid=107');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Laptopuri cu conexiune la Internet pentru studentii UBB - Rezultate finale', 'Anunt important pentru Studentii FSEGA cu Bursa de Ajutor Social: Ridicarea Laptopurilor prin Proiectul TIC4UBB începe pe 12 Decembrie 2023!', 1, 3, 'https://econ.ubbcluj.ro/stire.php?id=1265');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Evaluarea cadrelor didactice de catre studenti in semestrul 1 al anului universitar 2023-2024', 'Incepe Evaluarea Prestatiei Didactice: Studentii Invitati sa Completeze Evaluarile pentru Semestrul 1, 2022-2023!', 1, 3, 'https://econ.ubbcluj.ro/stire.php?id=1264');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Informatii privind sesiunea de examene aferenta semestrului 1 al anului universitar 2023-2024', 'Anunt Important: Programarea Examenelor si Achitarea Taxelor in Semestrul 1, 2023-2024!', 1, 3, 'https://econ.ubbcluj.ro/stire.php?id=1261');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Programare Sesiune Iarna', 'In vederea sefilor de an', 2, 4, 'https://ac.utcluj.ro/anunt/programare-sesiune-iarna-2.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Contracte Discipline Modificate', 'Se aplica doar din anul universitar 2024-2025', 2, 4, 'https://ac.utcluj.ro/anunt/contracte-discipline-modificate.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Burse 2023-2024', 'Noul regulament de acordare al burselor', 2, 4, 'https://ac.utcluj.ro/anunt/burse-sociale-speciale-si-stiintifice-semestrul-1-2022-2023-copy.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Organizare vizita la firma TeraPlast', 'Descopera Lumea Profesionala! OSUT organizeaza o Vizita la TeraPlast prin Proiectul InfoTech pe 8 Decembrie', 2, 5, 'https://constructii.utcluj.ro/anunt/organizare-vizita-la-firma-teraplast.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Vulcanus in Japan 2024 - Industrial traineeship for EU / Cosme students', 'Oportunitate Unica: Programul de burse "Vulcanus in Japan" pentru Anul Universitar 2024-2025 a fost Lansat!', 2, 5, 'https://constructii.utcluj.ro/anunt/vulcanus-in-japan-2024-industrial-traineeship-for-eu-cosme-students.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('In atentia studentilor din anul IV Licenta si anul II Master', 'Important: Inscriere Proiect de Diploma/Disertatie pentru Studentii Anului IV Licenta si Anului II Master!', 2, 5, 'https://constructii.utcluj.ro/anunt/in-atentia-studentilor-din-anul-iv-licenta-si-anul-ii-master-3.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Rezultate concurs TIE 2023', 'Performanta Exceptionala: Studentul Vlad Veliciu Obtine Mentiune in Finala Concursului TIE 2023!', 2, 6, 'https://etti.utcluj.ro/anunt/rzeultate-concurs-tie-2023.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Info decontare abonamente transport in comun', 'Abonamente transport in comun', 2, 6, 'https://etti.utcluj.ro/anunt/info-decontare-abonamente-transport-in-comun.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Workshop-uri Analog Devices - noiembrie 2023', 'Explorare Tehnologica: Analog Devices si Facultatea de Electronica ofera Studentilor 4 Workshop-uri Captivante!', 2, 6, 'https://etti.utcluj.ro/anunt/workshop-uri-analog-devices-noiembrie-2023.html');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Finalizare proiect – PROGRAM POSTUNIVERSITAR DE FORMARE IN ECONOMIA SANATATII', 'Universitati Medicale de Prestigiu in Parteneriat pentru Proiectul Postuniversitar de Formare in Economia Sanatatii', 3, 7, 'https://umfcluj.ro/universitate/noutati/finalizare-proiect-program-postuniversitar-de-formare-in-economia-sanatatii-healthesis-pocu-918-4-8-149892/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Examen de promovare in cariera didactica, etapa I, an universitar 2023-2024', 'UMF Cluj-Napoca Anunta Examen de Promovare in Cariera Didactica!', 3, 7, 'https://umfcluj.ro/universitate/noutati/examen-de-promovare-in-cariera-didactica-etapa-i-an-universitar-2023-2024/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Concurs ocupare posturi didactice vacante, pe durata nedeterminata, etapa I, an universitar 2023-2024', 'Anunt Concurs: Ocuparea Posturilor Didactice la UMF Iuliu Hatieganu Cluj-Napoca!', 3, 7, 'https://umfcluj.ro/universitate/noutati/concurs-ocupare-posturi-didactice-vacante-pe-durata-nedeterminata-etapa-i-an-universitar-2023-2024/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Evaluarea facilitatilor si serviciilor de suport de catre studenti, a.u. 2023-2024', 'Evalueaza-ti Experienta: Participa la Evaluarea Facilitatilor si Serviciilor UMF Iuliu Hatieganu!', 3, 8, 'https://umfcluj.ro/universitate/noutati/evaluarea-facilitatilor-si-serviciilor-de-suport-de-catre-studenti-a-u-2023-2024/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Saptamana bobocului la UMF Iuliu Hatieganu din Cluj-Napoca', 'Zilele Bobocilor la UMF Iuliu Hatieganu: O Saptamana Plina de Integrare si Acomodare!', 3, 8, 'https://umfcluj.ro/universitate/noutati/program-saptamana-bobocilor/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Saptamana Bobocului Universitatea de Medicina si Farmacie Iuliu Hatieganu Cluj-Napoca 25-29 Septembrie 2023 – Facultatea de Medicina', 'Bun Venit la Facultatea de Medicina! Saptamana Bobocului la UMF Iuliu Hatieganu', 3, 8, 'https://umfcluj.ro/universitate/noutati/saptamana-bobocului-universitatea-de-medicina-si-farmacie-iuliu-hatieganu-cluj-napoca-25-29-septembrie-2023-facultatea-de-medicina/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Evaluarea facilitatilor si serviciilor de suport de catre studenti, a.u. 2023-2024', 'Evalueaza-ti Experienta: Participa la Evaluarea Facilitatilor si Serviciilor UMF Iuliu Hatieganu!', 3, 9, 'https://umfcluj.ro/universitate/noutati/evaluarea-facilitatilor-si-serviciilor-de-suport-de-catre-studenti-a-u-2023-2024/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Saptamana bobocului la UMF Iuliu Hatieganu din Cluj-Napoca', 'Zilele Bobocilor la UMF Iuliu Hatieganu: O Saptamana Plina de Integrare si Acomodare!', 3, 9, 'https://umfcluj.ro/universitate/noutati/program-saptamana-bobocilor/');
	INSERT INTO Announcements(title, text, university, faculty, url) VALUES ('Saptamana Bobocului Universitatea de Medicina si Farmacie Iuliu Hatieganu Cluj-Napoca 25-29 Septembrie 2023 – Facultatea de Medicina', 'Bun Venit la Facultatea de Medicina! Saptamana Bobocului la UMF Iuliu Hatieganu', 3, 9, 'https://umfcluj.ro/universitate/noutati/saptamana-bobocului-universitatea-de-medicina-si-farmacie-iuliu-hatieganu-cluj-napoca-25-29-septembrie-2023-facultatea-de-medicina/');
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Euphoria Music Hall', 'Club', 46.763159, 23.571400, 'https://andrei-forminte.online/project/euphoria.png', 'https://euphoria.ro/restaurante-cluj/music-hall/', 'Monday : close
	Tuesday : close
	Wednesday: close
	Thursday : 22:00 - 05:00
	Friday: 22:00 - 05:00
	Saturday : 22:00 - 05:00
	Sunday : close');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Flying Circus', 'Club', 46.770770, 23.588576, 'https://andrei-forminte.online/project/flying_circus.png', 'https://www.instagram.com/flyingcircuscluj/', 'Monday : close
	Tuesday : close
	Wednesday: close
	Thursday : 22:00 - 05:00
	Friday: 22:00 - 05:00
	Saturday : 22:00 - 05:00
	Sunday : close');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Noa', 'Club', 46.757003, 23.594348, 'https://andrei-forminte.online/project/noa.png', 'https://clubnoa.ro/', 'Monday : close
	Tuesday : close
	Wednesday: close
	Thursday : 22:00 - 05:00
	Friday: 22:00 - 05:00
	Saturday : 22:00 - 05:00
	Sunday : close');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Memo 10', 'Restaurant', 46.770015, 23.587358, 'https://andrei-forminte.online/project/memo.png', 'https://www.facebook.com/LikeMemo10/?locale=ro_RO', 'Monday : 11:00 - 18:00
	Tuesday : 11:00 - 18:00
	Wednesday: 11:00 - 18:00
	Thursday : 11:00 - 18:00
	Friday: 11:00 - 18:00
	Saturday : close
	Sunday : close');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Livada', 'Restaurant', 46.766118, 23.582322, 'https://andrei-forminte.online/project/livada.png', 'https://www.livadarestaurant.ro/', 'Monday : 10:00 - 23:00
	Tuesday : 10:00 - 23:00
	Wednesday: 10:00 - 23:00
	Thursday : 10:00 - 23:00
	Friday: 10:00 - 23:00
	Saturday : 10:00 - 23:00
	Sunday : 10:00 - 23:00');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Samsara Foodhouse', 'Restaurant', 46.771011, 23.583675, 'https://andrei-forminte.online/project/samsara.png', 'https://samsara.ro/', 'Monday : 12:00 - 23:00
	Tuesday : 12:00 - 23:00
	Wednesday: 12:00 - 23:00
	Thursday : 12:00 - 23:00
	Friday: 12:00 - 23:00
	Saturday : 12:00 - 23:00
	Sunday : 12:00 - 23:00');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Tucano Coffe Puerto Rico', 'Cafenea', 46.770152, 23.593043, 'https://andrei-forminte.online/project/tucano.png', 'https://www.facebook.com/TucanoCoffeePuertoRico/', 'Monday : 08:00 - 21:00
	Tuesday : 08:00 - 21:00
	Wednesday: 08:00 - 21:00
	Thursday : 08:00 - 21:00
	Friday: 08:00 - 21:00
	Saturday : 09:00 - 22:00
	Sunday : 10:00 - 21:00');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Sisters', 'Cafenea', 46.768499, 23.589873, 'https://andrei-forminte.online/project/sisters.png', 'https://www.instagram.com/cafeneaua_sisters/', 'Monday : 07:00 - 00:00
	Tuesday : 07:00 - 00:00
	Wednesday: 07:00 - 00:00
	Thursday : 07:00 - 00:00
	Friday: 07:00 - 00:00
	Saturday : 10:00 - 00:00
	Sunday : 10:00 - 00:00');
	INSERT INTO Locations(name, type, latitude, longitude, img, site, description) VALUES ('Form Cafe', 'Cafenea', 46.772374, 23.587503, 'https://andrei-forminte.online/project/form_caffee.png', 'https://www.instagram.com/form_cafe/', 'Monday : 10:00 - 01:00
	Tuesday : 10:00 - 01:00
	Wednesday: 10:00 - 01:00
	Thursday : 10:00 - 01:00
	Friday: 10:00 - 02:00
	Saturday : 10:00 - 02:00
	Sunday : 10:00 - 00:00');
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Sambata Retro', 'O calatorie muzicala in trecut cu cele mai bune hituri retro', '2023-12-20 20:30:00', 1, 95);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara DJ-ului Nebun', 'O noapte de beats nebuni cu DJ-ul nostru principal', '2023-12-15 22:00:00', 1, 73);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Concert Live: Trupa Nebunia', 'Experimentati energia live a trupei Nebunia', '2023-12-25 21:00:00', 1, 54);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara Dansului Latino', 'Invatati sa dansati salsa si merengue cu instructori profesionisti', '2023-12-30 19:00:00', 2, 68);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Noaptea Tematica a Anilor 80', 'Calatoriti inapoi in timp cu cele mai bune hituri ale anilor 80', '2024-01-05 23:00:00', 2, 82);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Party de Revelion', 'Sarbatoriti trecerea in noul an cu muzica live si sampanie', '2023-12-31 23:30:00', 2, 59);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Karaoke Night', 'Demonstrati-va talentul vocal intr-o seara distractiva de karaoke', '2024-01-10 20:00:00', 3, 63);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara Stand-up Comedy', 'O seara plina de ras cu cei mai buni comedianti din oras', '2024-01-15 21:30:00', 3, 87);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Festivalul de Muzica Electronica', 'O noapte de nebunie cu DJ internationali de top', '2024-01-25 22:30:00', 3, 50);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Cina Degustare de Vinuri', 'Descoperiti combinatii delicioase de vinuri cu preparate rafinate', '2023-12-10 19:30:00', 4, 72);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara Muzicala cu Pian', 'O atmosfera relaxanta cu muzica live la pian si meniu special', '2023-12-18 20:00:00', 4, 98);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Sarbatoare Gastronomica Locala', 'Bucurati-va de preparate traditionale locale si muzica folk', '2023-12-22 18:30:00', 4, 61);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Brunch Duminical cu Jazz Live', 'Experimentati o dimineata relaxanta cu muzica jazz si preparate delicioase', '2023-12-25 11:00:00', 5, 88);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Curs de Gatit cu Chef', 'Invatati tehnici de gatit de la bucatari profesionisti si savurati propriile creatii', '2024-01-08 16:00:00', 5, 55);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Petrecere Privata in Salon', 'Rezervati un salon pentru o petrecere privata cu meniu personalizat', '2024-01-15 19:00:00', 5, 76);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara Tematica cu Specific International', 'Explorati bucate din bucatarii din intreaga lume si dansati pe ritmuri internationale', '2024-01-20 20:30:00', 6, 91);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Degustare de Ciocolata si Vin', 'O experienta senzoriala cu combinatii delicioase de ciocolata si vin', '2024-01-28 18:00:00', 6, 67);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Noapte a Cuplurilor', 'O cina romantica pentru cupluri cu meniu special si muzica live', '2024-02-05 19:00:00', 6, 78);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara de Poezie si Cafea', 'Ascultati poeziile unor artisti locali in timp ce va bucurati de o ceasca de cafea', '2023-12-12 19:00:00', 7, 99);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Quiz Nocturn cu Premii', 'Participati la un quiz distractiv si aveti sansa sa castigati premii atractive', '2023-12-16 20:00:00', 7, 74);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Serata Acustica', 'Muzica live acustica pentru o atmosfera relaxanta', '2023-12-20 18:30:00', 7, 52);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Atelier de Desen si Cappuccino', 'Experimentati arta desenului in timp ce savurati o bautura delicioasa', '2023-12-26 15:00:00', 8, 89);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Curs de Barista', 'Invatati secretele prepararii unui espresso perfect si creati propriile bauturi', '2024-01-10 17:30:00', 8, 97);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Seara de Board Games', 'Petreceti o seara distractiva jucand jocuri de societate cu prietenii', '2024-01-18 19:00:00', 8, 64);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Lansare Carte Locala', 'Descoperiti noutatile editoriale ale autorilor locali cu un pahar de vin sau cafea', '2024-01-25 18:00:00', 9, 83);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Open Mic Night', 'Oportunitate pentru artistii amatori sa isi prezinte talentele intr-un mediu relaxant', '2024-02-02 20:30:00', 9, 66);
	INSERT INTO Events (name, description, eventDate, location, participants) VALUES ('Happy Hour cu Muzica Jazz', 'Bucurati-va de oferte speciale la bauturi in timp ce ascultati trupe de jazz locale', '2024-02-08 18:00:00', 9, 93);
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Care sunt principalele teme acoperite in cursul de Calcul Diferential?', '2023-12-01', 'Academic', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Ce site-uri sau carti recomandati pentru aprofundarea materiei de Anatomie?', '2023-12-02', 'Academic', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Cum faceti fata perioadelor aglomerate si stresante de examene?', '2023-12-03', 'Academic', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Care sunt evenimentele sociale planificate pentru aceasta luna?', '2023-12-04', 'Student Life', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Cum gasiti parteneri de incredere pentru proiecte sau studiu in grup?', '2023-12-05', 'Student Life', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Aveti sfaturi pentru gestionarea timpului si mentinerea unui echilibru intre viata academica si cea personala?', '2023-12-06', 'Student Life', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Cum pot gasi oportunitati de stagii in domeniul meu de studiu?', '2023-12-07', 'Career Development', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Ce elemente ar trebui sa includ in portofoliul meu online?', '2023-12-08', 'Career Development', '');
	INSERT INTO Questions (text, questionDate, category, posterId) VALUES ('Unde pot participa la workshop-uri pentru dezvoltarea abilitatilor soft?', '2023-12-09', 'Career Development', '');
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Cursul de Calcul Diferential acopera notiuni precum derivatele si aplicatiile lor in matematica si stiinte aplicate.', '2023-12-01', '', 1);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Pentru Anatomie, recomand sa consulti atlase si manuale precum "Gray''s Anatomy" si "Atlas of Human Anatomy."', '2023-12-02', '', 2);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Pentru perioadele stresante, sfaturi includ planificarea si gestionarea timpului, odihna adecvata si folosirea tehnicilor de relaxare.', '2023-12-03', '', 3);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Exista diverse evenimente sociale, inclusiv seri tematice in cluburi, conferinte si activitati organizate de organizatiile studentesti.', '2023-12-04', '', 4);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Pentru a gasi parteneri de incredere, poti participa la cluburi si evenimente studentesti sau folosi platforme online precum studiogroups.com.', '2023-12-05', '', 5);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Gestionarea timpului implica stabilirea prioritatilor, crearea unui program si comunicarea deschisa cu colegii pentru a coordona studiul in grup.', '2023-12-06', '',6);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Pentru a gasi stagii, verifica site-urile specializate precum eJobs, LinkedIn si portalurile companiilor din domeniul tau.', '2023-12-07', '',7);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Un portofoliu ar trebui sa includa proiecte de succes, competente cheie si recomandari relevante de la profesori si colegi.', '2023-12-08', '', 8);
	INSERT INTO Answers (text, answerDate, posterId, question) VALUES ('Participarea la conferinte, evenimente de networking si workshop-uri te poate ajuta sa dezvolti abilitatile soft si sa te orientezi profesional.', '2023-12-09', '', 9);
COMMIT TRANSACTION

BEGIN TRANSACTION
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 1);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 2);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 3);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 4);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 5);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 6);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 7);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 8);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 9);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 10);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 11);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 12);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 13);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 14);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 15);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 16);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 17);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 18);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 19);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 20);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 21);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 22);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 23);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 24);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 25);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 26);
	INSERT INTO Participants(userEmail, eventId) VALUES ('', 27);
COMMIT TRANSACTION