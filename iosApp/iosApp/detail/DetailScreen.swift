//
//  DetailScreen.swift
//  iosApp
//
//  Created by Minh Nguyen on 24/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//
import shared
import SwiftUI

struct DetailScreen: View {
    let movie: Movie
    var body: some View {
        ScrollView {
            VStack {
                ZStack {
                    AsyncImage(url: URL(string: movie.imageUrl)) {
                        image in image.resizable().scaledToFill()
                    }placeholder: {
                        ProgressView()
                    }
                }
                .frame(maxWidth: .infinity, minHeight: 300, maxHeight: 300)
                VStack(alignment: .leading, spacing: 12) {
                    Text(movie.title)
                        .font(.title)
                        .fontWeight(.bold)
                        .fixedSize(horizontal: false, vertical: true)
                    Button(action: {}) {
                        HStack {
                            Image(systemName: "play.fill")
                                .foregroundColor(.white)
                            Text("Start Watching Now")
                                .foregroundColor(.white)
                        }
                    }
                    .frame(maxWidth: .infinity, maxHeight: 40)
                    .padding()
                    .background(.red)
                    .clipShape(RoundedRectangle(cornerRadius: 8))
                    Text("Released in \(movie.releaseDate)".uppercased())
                    
                    Text(movie.description_)
                        .font(.body)
                        .fixedSize(horizontal: false, vertical: true)
                }
                .padding(20)
                .background(.black)
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity)
        }
    }
}

struct DetailScreen_Previews: PreviewProvider {
    static var previews: some View {
        DetailScreen(movie: sampleMovie)
    }
}
