import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';

import Login from './modules/Login';
import Navigation from './config/navigation/Navigation';
import Perfil from './modules/Perfil';

///consultas
import Consulta from './modules/screens/Consulta';
import ConsDami from './modules/screens/ConsDami';
import ConsDatefi from './modules/screens/ConsDatefi';
import ConsDacea from './modules/screens/ConsDacea';



import { NavigationContainer } from '@react-navigation/native'; 

export default function App() {
  return (
    //<Login/>
    <Navigation/>
    //<ConsDacea/>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
