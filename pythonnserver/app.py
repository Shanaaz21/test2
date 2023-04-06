from flask import Flask, request, jsonify
from flask_cors import CORS
import pickle
import pandas as pd

with open('university_prediction_model.pkl', 'rb') as file:
    loaded_model = pickle.load(file)

# Define a Flask app
app = Flask(__name__)
from flask_cors import CORS

def return_dict(pred):
    df = pd.read_csv('cwurData.csv')
    df = df.drop_duplicates()
    df = df.dropna()
    row = df.loc[df['institution'] == pred, :].iloc[0].to_dict()
    return row

@app.route('/predict', methods=['POST'])
def predict():

    # Get inputs from request
    quality_of_education= float(request.json['qualityOfEducation'])
    quality_of_faculty= float(request.json['qualityOfFaculty'])
    influence= float(request.json['influence'])
    score= float(request.json['score'])

    #prediction
    prediction = loaded_model.predict([[quality_of_education,quality_of_faculty,influence,score]])
    
    # Return prediction as response
    return return_dict(prediction[0])

# Run the Flask app
if __name__ == '__main__':
    app.run(debug=True)