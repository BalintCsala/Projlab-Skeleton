import os

for dirpath, dirnames, files in os.walk("src"):
    for file in files:
        if file.endswith(".java"):
            print(str(file) + str("        ") + str(os.path.getsize(dirpath + "/" + file)))