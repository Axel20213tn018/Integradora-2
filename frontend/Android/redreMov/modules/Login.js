import { StyleSheet, Text, View, Dimensions } from "react-native";
import React, { useState } from "react";
import Icon from "react-native-vector-icons/FontAwesome5";
import { Button, Input, Image } from "@rneui/base";
import Perfil from "./Perfil";

export default function Login() {
  const payLoad = {
    matricula: "",
    password: "",
  };
  // const auth = getAuth()
  const [show, setShow] = useState(false);
  const [error, setError] = useState(payLoad);
  const [data, setData] = useState(payLoad);
  const [showPassword, setShowPassword] = useState(true);
  const changePayLoad = (e, type) => {
    setData({ ...data, [type]: e.nativeEvent.text });
  };
  return (
    <View style={styles.container}>
      <Text style={styles.title}>REDRE</Text>

      <View style={styles.cardContainer}>
        <Image source={require("../assets/user.png")} style={styles.profile} />
        <Input
          style={{ marginLeft: 10 }}
          placeholder="Matrícula"
          leftIcon={<Icon name="user-alt" size={24} color="gray" />}
        />
        <Input
          style={{ marginLeft: 10 }}
          placeholder="Contraseña"
          leftIcon={<Icon name="lock" size={24} color="gray" />}
          rightIcon={
            <Icon
              name={showPassword ? "eye-slash" : "eye"}
              onPress={() => setShowPassword(!showPassword)}
              size={22}
              color="gray"
            />
          }
          secureTextEntry={showPassword}
          onChange={(e) => changePayLoad(e, 'password')}
          errorMessage={error.password}
        />
        <Button
          title="Iniciar sesión"
          buttonStyle={styles.logBtn}
          as={Perfil}
        />
      </View>
    </View>
  );
}

const deviceContainer = Math.round(Dimensions.get("window").width);

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#1C8F71",
    alignItems: "center",
    justifyContent: "center",
  },
  cardContainer: {
    width: deviceContainer - 50,
    backgroundColor: "#fff",
    height: 350,
    borderRadius: 30,
    alignItems: "center",
  },
  profile: {
    width: 80,
    height: 80,
    margin: 20,
  },
  title: {
    fontFamily: "Roboto",
    fontSize: 35,
    fontWeight: "500",
    color: "#fff",
    marginBottom: 30,
  },
  logBtn: {
    alignSelf: "center",
    backgroundColor: "#012258",
    borderRadius: 500,
  },
});
