import { StyleSheet, Text, View, Dimensions } from "react-native";
import React from "react";

import Icon from "react-native-vector-icons/FontAwesome";

export default function Perfil() {
  return (
    <View style={styles.container}>
      <View style={styles.card}>
        <View
          style={{
            flexDirection: "row",
            alignItems: "center",
            marginTop: 25,
            width: "100%",
          }}
        >
          <View style={{ width: "50%" }}>
            <Text
              style={{
                fontSize: 20,
                fontWeight: "bold",
                color: "#fff",
                marginTop: 35,
              }}
            >
              REDRE
            </Text>
          </View>

          <View style={{ width: "50%", alignItems: "flex-end", marginTop: 30 }}>
            <Icon name="power-off" size={24} color="white" />
          </View>
        </View>
      </View>

      <View
        style={{
          backgroundColor: "#fff",
          paddingVertical: 8,
          /*paddingHorizontal:20,*/
          // marginHorizontal:20,
          borderRadius: 15,
          marginTop: 140,
          /* flexDirection: "row",
          alignItems: "center",*/
          position: "absolute",
          alignSelf: "center",
          width: 300,
        }}
      >
        <View
          style={{ /*width: "100%",*/ alignItems: "center", marginTop: 20 }}
        >
          <Icon name="user" size={100} color="#555555" />
          <Text style={styles.textName}>Nombre del Alumno</Text>
        </View>
      </View>

      <View style={styles.data1}>
        <View style={{ alignItems: "flex-start" }}>
          <Icon
            style={{ marginLeft: 15 , position: 'absolute'}}
            name="circle"
            size={24}
            color="#012258"
          />
          <Text style={styles.textData}>Matrícula</Text>
        </View>
      </View>

      <View style={styles.data2}>
        <View style={{ alignItems: "flex-start" }}>
          <Icon
           style={{ marginLeft: 15 , position: 'absolute'}}
            name="circle"
            size={24}
            color="#012258"
          />
          <View>
            <Text style={styles.textData}>División Académica</Text>
          </View>
        </View>
      </View>

      <View style={styles.data2}>
        <View style={{ alignItems: "flex-start" }}>
          <Icon
            style={{ marginLeft: 15 , position: 'absolute'}}
            name="circle"
            size={24}
            color="#012258"
          />
            <Text style={styles.textData}>Carrera</Text>
        </View>
      </View>

      <View style={styles.data2}>
      <View style={{ alignItems: "flex-start" }}>
          <Icon
            style={{ marginLeft: 15 , position: 'absolute'}}
            name="circle"
            size={25}
            color="#012258"
          />
            <Text style={styles.textData}>Grado y grupo</Text>
            </View>
      </View>


    </View>
  );
}

const deviceContainer = Math.round(Dimensions.get("window").width);

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#EFEFEF",
  },
  card: {
    backgroundColor: "#1C8F71",
    height: "25%",
    /*borderBottomLeftRadius: 20,
    borderBottomRightRadius: 20,*/
    paddingHorizontal: 20,
  },
  textName: {
    margin: 15,
    fontFamily: "Roboto",
    fontSize: 25,
  },
  data1: {
    backgroundColor: "#fff",
    paddingVertical: 8,
    /*paddingHorizontal:20,*/
    // marginHorizontal:20,
    borderRadius: 15,
    marginTop: 180,
    /* flexDirection: "row",
                        alignItems: "center",*/
    alignSelf: "center",
    width: 300,
  },
  data2: {
    backgroundColor: "#fff",
    paddingVertical: 10,
    borderRadius: 15,
    marginTop: 30,
    alignSelf: "center",
    width: 300,
  },
  textData: {
    fontFamily: "Roboto",
    fontSize: 17,
    marginLeft: 45
  },
});
