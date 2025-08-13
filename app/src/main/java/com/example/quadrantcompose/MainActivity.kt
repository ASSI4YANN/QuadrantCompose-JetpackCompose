package com.example.quadrantcompose

import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrantcompose.ui.theme.QuadrantComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuadrantComposeTheme {
                MaterialTheme {
                    QuadrantCompose()
                }
            }
        }
    }
}

// Fonction compose pour afficher le résultat
@Composable
fun QuadrantCompose() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantComposeItem(
                title = stringResource(R.string.t_1),
                description = stringResource(R.string.desc_1),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            QuadrantComposeItem(
                title = stringResource(R.string.t_2),
                description = stringResource(R.string.desc_2),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantComposeItem(
                title = stringResource(R.string.t_3),
                description = stringResource(R.string.desc_3),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)

            )
            QuadrantComposeItem(
                title = stringResource(R.string.t_4),
                description = stringResource(R.string.desc_4),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// Fonction compose pour les items : titre , description , couleur
@Composable
fun QuadrantComposeItem(
    title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier
) {
    Box( // pour empiler le texte sur le backgroundColor
        modifier = modifier
            .fillMaxHeight()
            .background(backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.Center

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp), // marge intérieure inférieure

            )
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium, // bodyMedium c'est un style de "corps de texte" de taille moyenne ( 16.sp par defaut)
                textAlign = TextAlign.Justify
            )
        }
    }

}


// Fonction composable preview pour afficher l'aperçu de l'UI
@Preview(showBackground = true)
@Composable
fun QuadrantComposePreview() {
    QuadrantComposeTheme {
        QuadrantCompose()
    }
}