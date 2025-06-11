# Whenever a class is instantiated, two methods are called:

# __new__ : Responsible for creating a new instance of the class.
# __init__ : Initializes the instance.

# ✅ What is __new__?
# __new__ is a special method in Python responsible for creating a new instance of a class.
# It is called before __init__, and it actually returns the instance.
# It's used in Singleton patterns to control object creation.

class HospitalLogger:

    __instance = None 

    def __new__(cls):
        if cls.__instance is None:
            print('Logger is instantiated')
            cls.__instance = super(HospitalLogger,cls).__new__(cls)
        return cls.__instance

    def log(self,msg):
        print('Log:',msg)
    

if __name__ == '__main__':

    logger1 = HospitalLogger()
    logger1.log('Patient registered')

    logger2 = HospitalLogger()
    logger2.log('Room booked')

    print(logger1 == logger2)

    