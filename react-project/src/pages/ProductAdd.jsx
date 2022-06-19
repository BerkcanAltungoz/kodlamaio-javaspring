import React from 'react'
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {Button, FormField, Label} from "semantic-ui-react";
import KodlamaIoTextInput from "../utilities/customFormControls/KodlamaIoTextInput";

export default function ProductAdd() {
    const initialValues = { productName: "", unitPrice: 0 }
    const schema = Yup.object({
        productName: Yup.string().required("Ürün adı zorunlu"),
        unitPrice: Yup.number().required("Ürün fiyatı zorunlu")
    });
    return (
        <div>
            <Formik initialValues={initialValues}
                    validationSchema={schema}
                    onSubmit={(values)=>{
                        console.log(values)}}
            >
                <Form className="ui form">
                    <KodlamaIoTextInput name={"productName"} placeholder={"Ürün Adı"} />
                  {/*  <FormField>
                        <label>Ürün Adı</label>
                        <Field name = "productName"></Field>
                        <ErrorMessage name={"productName"} render={error=>
                            <Label pointing basic color="red" content={error}></Label>
                        }></ErrorMessage>
                    </FormField>*/}
                    <KodlamaIoTextInput name={"unitPrice"} placeholder={"Ürün Fiyatı"} />
                    <Button color = "green" type = "submit">Ekle</Button>
                </Form>
            </Formik>
        </div>
    )
}
