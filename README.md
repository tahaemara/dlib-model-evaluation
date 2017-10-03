# Dlib's face recognition model accuracy test

Using information about LFW evaluation protocol from here http://vis-www.cs.umass.edu/lfw/README.txt

I developed an application built on [this example](https://github.com/davisking/dlib/blob/master/examples/dnn_face_recognition_ex.cpp) and saved the result (face_descriptor vector) for every image in LFW not aligned dataset, to csv file -I uploaded it (data.csv)-. Then I used the code in this repository to test dlib’s face recognition model. 

I used the Image restricted configuration to test this model based on file [pairs.txt],

Number of faces: 13075

Number of Tests: 6000

Accuracy: 98.4

## NOTE
- Dilb's face recogntion model was tested under Unrestricted, Labeled Outside Data Results configuration and gave 99.38% accuracy. 
- You may notice that the data contains 130175 even that the LFW contains 13233 image this is because Dlib's face detector can't detect these 58 files

(Abdoulaye_Wade_0003, Anna_Kournikova_0005, Ariel_Sharon_0018, Ariel_Sharon_0067, Arlen_Specter_0003, Arnold_Schwarzenegger_0029, Britney_Spears_0008, Carroll_Weimer_0001, Chan_Ho_Park_0001, Claudia_Pechstein_0005, Colin_Montgomerie_0004, Dale_Earnhardt_Jr_0003, David_Beckham_0020, David_Wells_0003, David_Wells_0007, Derrick_Rodgers_0001, Don_Hewitt_0001, Ed_Mekertichian_0001, Elisabeth_Schumacher_0001, Hamid_Karzai_0006, Harvey_Wachsman_0001, Jack_Nicholson_0001, Jacques_Chirac_0006, Jacques_Chirac_0010, James_McGreevey_0002, Jane_Fonda_0002, Jaouad_Gharib_0001, Jeffrey_Pfeffer_0001, Jelena_Dokic_0004, Jennifer_Capriati_0031, Joe_Vandever_0001, John_Baldacci_0001, John_Burkett_0001, John_Thune_0001, Jon_Stewart_0001, Li_Peng_0004, Luis_Horna_0002, Lynne_Thigpen_0001, Mahmoud_Abbas_0021, Mark_Philippoussis_0011, Marlon_Devonish_0001, Martin_Hoellwarth_0001, Mohammad_Khatami_0007, Muammar_Gaddafi_0001, Philippe_Noiret_0002, Queen_Elizabeth_II_0008, Rob_Moore_0001, Rob_Ramsay_0001, Robert_Zoellick_0005, Roseanne_Barr_0001, Rudolph_Giuliani_0007, Rupert_Murdoch_0002, Steve-O_0001, Susan_Collins_0001, Tatiana_Gratcheva_0001, Thomas_Birmingham_0002, Thor_Pedersen_0001, Yasser_Arafat_0004)
