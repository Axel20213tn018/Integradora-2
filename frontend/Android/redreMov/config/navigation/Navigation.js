import { StyleSheet, Text, View, Touchable } from "react-native";
import React from "react";
//import { Icon } from "@rneui/base";
import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import Consulta from "../../modules/screens/Consulta";
import Perfil from "../../modules/Perfil";

import Icon from "react-native-vector-icons/FontAwesome";

///vistas
const Tab = createBottomTabNavigator();

export default function Navigation() {
  return (
    <NavigationContainer>
      <Tab.Navigator
        screenOptions={({ route }) => ({
          headerShown:false,
          tabBarIcon: ({ color }) => screenOptions(route, color),
          tabBarActiveTintColor: "white",
          tabBarInactiveTintColor: "gray",
          tabBarStyle: { backgroundColor: "#012258" },
        })}
      >
        <Tab.Screen name="Perfil" component={Perfil} /*options={{headerShown:true}}*//>
        <Tab.Screen name="Consulta" component={Consulta} />
      </Tab.Navigator>
    </NavigationContainer>
  );
}

const screenOptions = (route, color) => {
  let iconName;
  switch (route.name) {
    case "Perfil":
      iconName = "user";
      break;
    case "Consulta":
      iconName = "search";
      break;
    default:
      break;
  }
  return (
    <Icon /*type='material-community'*/
      name={iconName}
      size={22}
      color={color}
    ></Icon>
  );
};
